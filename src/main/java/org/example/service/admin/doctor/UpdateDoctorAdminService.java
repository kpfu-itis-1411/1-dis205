package org.example.service.admin.doctor;

import org.example.repositories.DoctorRepository;
import org.example.service.HashPasswordService;

import javax.servlet.http.HttpServletRequest;

public class UpdateDoctorAdminService {
    private DoctorRepository doctorRepository;
    private final HashPasswordService hashPasswordService;

    public UpdateDoctorAdminService(DoctorRepository doctorRepository, HashPasswordService hashPasswordService) {
        this.doctorRepository = doctorRepository;
        this.hashPasswordService = hashPasswordService;
    }

    public void updateDoctor(HttpServletRequest req) {
        Long id = Long.valueOf(req.getParameter("idupdate"));
        String name = req.getParameter("nameupdate");
        String surname = req.getParameter("surnameupdate");
        String email = req.getParameter("emailupdate");
        String post = req.getParameter("postupdate");
        String password = req.getParameter("passwordupdate");
        String passwordMD5 = hashPasswordService.encrypt(password);

        doctorRepository.updateDoctorById(id, name, surname, email, post, passwordMD5);
    }
}


