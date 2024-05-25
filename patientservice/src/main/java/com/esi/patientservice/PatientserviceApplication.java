package com.esi.patientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientserviceApplication {

	public static void main(String[] args) {
		DatabaseInitializer.initialize("patientservice_db");
		SpringApplication.run(PatientserviceApplication.class, args);
	}
}
