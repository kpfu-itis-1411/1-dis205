package org.example.exeptions;

public class DoctorOrAdminNotFoundException extends RuntimeException {
    public DoctorOrAdminNotFoundException() {
        super("Doctor or Admin not found");
    }
}


