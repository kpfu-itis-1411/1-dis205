package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Appointment {
    Long id;
    String name;
    String appointmentDate;
    Long doctorId;
    Long patientId;

}
