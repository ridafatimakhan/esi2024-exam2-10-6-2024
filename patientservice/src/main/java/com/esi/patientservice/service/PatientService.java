package com.esi.patientservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esi.patientservice.dto.PatientDto;
import com.esi.patientservice.model.Patient;
import com.esi.patientservice.repository.PatientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public void addPatientInfo(PatientDto patientDto) {
        // Map patientDto to Patient entity
        Patient patient = new Patient();
        patient.setId(patientDto.getId());
        patient.setName(patientDto.getName());
        patient.setData(patientDto.getData());

        // Save Patient entity to the database
        patientRepository.save(patient);
    }
}
