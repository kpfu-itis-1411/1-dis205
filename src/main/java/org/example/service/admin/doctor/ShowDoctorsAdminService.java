package org.example.service.admin.doctor;

import org.example.models.Doctor;
import org.example.repositories.DoctorRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowDoctorsAdminService {
    private DoctorRepository doctorRepository;

    public ShowDoctorsAdminService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void showDoctors(HttpServletRequest req) {
        List<Doctor> doctors = doctorRepository.findAllDoctors().stream().toList();

        req.setAttribute("doctorsadmin", doctors);

    }
}