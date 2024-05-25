package com.esi.patientservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patienttable")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    private String patientId;
    private String patientName;
    private String patientData;
}
