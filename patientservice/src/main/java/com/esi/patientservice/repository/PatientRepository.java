package com.esi.patientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esi.patientservice.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, String> {
}
