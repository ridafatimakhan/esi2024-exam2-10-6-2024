package com.esi.appointmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    private String appointmentid;
    private String patientId;
    private String patientName;
    private String drId;
    private String date;
}
