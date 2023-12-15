package org.example.service.admin.patient;

import org.example.repositories.PatientRepository;
import org.example.service.HashPasswordService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class UpdatePatientAdminService {
    private PatientRepository patientRepository;
    private final HashPasswordService hashPasswordService;

    public UpdatePatientAdminService(PatientRepository patientRepository, HashPasswordService hashPasswordService) {
        this.patientRepository = patientRepository;
        this.hashPasswordService = hashPasswordService;
    }

    public void updatePatient(HttpServletRequest req) {
        Long id = Long.valueOf(req.getParameter("idupdate"));
        String nameupdate = req.getParameter("nameupdate");
        String surnameupdate = req.getParameter("surnameupdate");
        String emailupdate = req.getParameter("emailupdate");
        Date dateOfBirth = Date.valueOf((req.getParameter("dateofbirthupdate")));
        System.out.println(dateOfBirth);
        String passwordupdate = req.getParameter("passwordupdate");
        String passwordMD5 = hashPasswordService.encrypt(passwordupdate);


        patientRepository.updatePatientById(id, nameupdate, surnameupdate, emailupdate, dateOfBirth, passwordMD5);
    }
}
