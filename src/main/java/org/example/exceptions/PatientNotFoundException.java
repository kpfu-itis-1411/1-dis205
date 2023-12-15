package org.example.exeptions;


public class PatientNotFoundException extends RuntimeException{
    public PatientNotFoundException() {
        super("Patient not found");
    }
}
