package org.example.service.admin.patient;

import org.example.models.Patient;
import org.example.repositories.PatientRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowPatientsAdminService {
    private PatientRepository patientRepository;

    public ShowPatientsAdminService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void showPatients(HttpServletRequest req) {
        List<Patient> patients = patientRepository.findAllPatients().stream().toList();

        req.setAttribute("patientsadmin", patients);

    }
}
