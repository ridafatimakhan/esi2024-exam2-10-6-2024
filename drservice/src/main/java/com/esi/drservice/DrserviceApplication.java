package com.esi.drservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DrserviceApplication {

	public static void main(String[] args) {
		DatabaseInitializer.initialize("drservice_db");
		SpringApplication.run(DrserviceApplication.class, args);
	}
}
