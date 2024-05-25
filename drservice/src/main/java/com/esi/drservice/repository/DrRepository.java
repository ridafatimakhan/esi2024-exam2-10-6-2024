package com.esi.drservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esi.drservice.model.Appointment;

public interface DrRepository extends JpaRepository<Appointment, String> {
}
