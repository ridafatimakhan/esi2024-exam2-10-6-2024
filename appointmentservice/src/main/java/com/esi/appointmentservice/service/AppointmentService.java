package com.esi.appointmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.esi.appointmentservice.dto.AppointmentDto;
import com.esi.appointmentservice.model.Appointment;
import com.esi.appointmentservice.repository.AppointmentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private KafkaTemplate<String, AppointmentDto> kafkaTemplate;

    private static final String APPOINTMENT_TOPIC = "appointment-topic";

    public void bookAppointment(AppointmentDto appointmentDto) {
        // Task 2.1
        Appointment appointment = mapToAppointment(appointmentDto);

        // Save
        appointmentRepository.save(appointment);
    }

    public void sendEventToDrService(AppointmentDto appointmentDto) {
        // Task 2.2
        kafkaTemplate.send(APPOINTMENT_TOPIC, appointmentDto);
    }

    private Appointment mapToAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(appointmentDto.getAppointmentId());
        appointment.setPatientId(appointmentDto.getPatientId());
        appointment.setDoctorId(appointmentDto.getDoctorId());
        appointment.setDate(appointmentDto.getDate());
        return appointment;
    }
}
