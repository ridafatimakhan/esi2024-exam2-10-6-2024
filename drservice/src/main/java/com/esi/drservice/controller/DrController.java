package com.esi.drservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.esi.drservice.service.DrService;

@RestController
@RequestMapping("/api")
public class DrController {

    @Autowired
    private DrService drService;

    private final WebClient.Builder webClientBuilder;

    public DrController(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @GetMapping("/appointments")
    public ResponseEntity<Flux<DrAppointment>> getAllAppointments() {
        Flux<DrAppointment> availableAppointments = drService.getAllAppointments();
        Flux<DrAppointment> appointmentsWithPatientData = availableAppointments.flatMap(this::fetchPatientData);

        return ResponseEntity.ok(appointmentsWithPatientData);
    }

    private Mono<DrAppointment> fetchPatientData(DrAppointment appointment) {
        return webClientBuilder.build()
                .get()
                .uri("http://patientservice/api/patients/{id}", appointment.getPatientId())
                .retrieve()
                .bodyToMono(String.class)
                .map(patientData -> {
                    appointment.setPatientData(patientData);
                    return appointment;
                });
    }
}
