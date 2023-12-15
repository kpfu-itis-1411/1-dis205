package org.example.service.admin.patient;

import org.example.repositories.AppointmentRepository;
import org.example.repositories.PatientRepository;

import javax.servlet.http.HttpServletRequest;

public class DeletePatientAdminService {
    private PatientRepository patientRepository;

    public DeletePatientAdminService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void deletePatient(HttpServletRequest req) {
        Long id = Long.valueOf(req.getParameter("iddelete"));
        patientRepository.deleteById(id);
    }
}
