package org.example.exeptions;

public class AppointmentNotFoundException extends RuntimeException{
    public AppointmentNotFoundException() {
        super("Appointment not found");
    }
}
