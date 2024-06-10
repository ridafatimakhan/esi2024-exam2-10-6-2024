package com.esi.drservice.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import org.springframework.kafka.annotation.KafkaListener;
import com.esi.drservice.dto.AppointmentDto;

@RequiredArgsConstructor
@Service
public class DrService {

    private final DrAppointmentRepository drAppointmentRepository;

    @KafkaListener(topics = "appointment-topic", groupId = "drservice-group")
    public void consumeAppointmentEvent(AppointmentDto appointmentDto) {
        saveAppointmentToDatabase(appointmentDto);
    }

    private void saveAppointmentToDatabase(AppointmentDto appointmentDto) {
        DrAppointment drAppointment = mapToDrAppointment(appointmentDto);
        // Save
        drAppointmentRepository.save(drAppointment);
    }

    private DrAppointment mapToDrAppointment(AppointmentDto appointmentDto) {
        DrAppointment drAppointment = new DrAppointment();
        drAppointment.setAppointmentId(appointmentDto.getAppointmentId());
        drAppointment.setPatientId(appointmentDto.getPatientId());
        drAppointment.setDoctorId(appointmentDto.getDoctorId());
        drAppointment.setDate(appointmentDto.getDate());
        return drAppointment;
    }
}
