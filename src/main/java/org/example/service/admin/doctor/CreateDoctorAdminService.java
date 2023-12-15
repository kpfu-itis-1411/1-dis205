package org.example.service.admin.doctor;

import org.example.models.Appointment;
import org.example.models.Doctor;
import org.example.models.Patient;
import org.example.repositories.AppointmentRepository;
import org.example.repositories.DoctorRepository;
import org.example.service.HashPasswordService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class CreateDoctorAdminService {
    private DoctorRepository doctorRepository;
    private HashPasswordService hashPasswordService;


    public CreateDoctorAdminService(DoctorRepository doctorRepository, HashPasswordService hashPasswordService) {
        this.doctorRepository = doctorRepository;
        this.hashPasswordService = hashPasswordService;
    }

    public void createDoctor(HttpServletRequest req) {
        String name = req.getParameter("doctorname");
        String surname = req.getParameter("doctorsurname");
        String email = req.getParameter("doctoremail");
        String post = req.getParameter("doctorpost");
        String password = req.getParameter("doctorpassword");
        String passwordMD5 = hashPasswordService.encrypt(password);

        Doctor doctor = Doctor.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .post(post)
                .password(password)
                .build();

        doctorRepository.saveDoctor(doctor);
    }



}
