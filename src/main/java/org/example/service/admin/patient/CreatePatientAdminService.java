package org.example.service.admin.patient;

import org.example.models.Appointment;
import org.example.models.Patient;
import org.example.repositories.AppointmentRepository;
import org.example.repositories.PatientRepository;
import org.example.service.HashPasswordService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class CreatePatientAdminService {
    private PatientRepository patientRepository;
    private final HashPasswordService hashPasswordService;

    public CreatePatientAdminService(PatientRepository patientRepository, HashPasswordService hashPasswordService) {
        this.patientRepository = patientRepository;
        this.hashPasswordService = hashPasswordService;
    }

    public void createPatient(HttpServletRequest req) {
        String name = req.getParameter("patientname");
        String surname = req.getParameter("patientsurname");
        String email = req.getParameter("patientemail");
        Date dateOfBirth = Date.valueOf((req.getParameter("patientdateofbirth")));
        String password = req.getParameter("patientpassword");
        String passwordMD5 = hashPasswordService.encrypt(password);


        Patient patient = Patient.builder().
                name(name).
                surname(surname).
                email(email).
                dateOfBirth(dateOfBirth).
                password(passwordMD5).build();

        patientRepository.savePatient(patient);
    }
}
