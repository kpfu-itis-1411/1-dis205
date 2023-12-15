package org.example.service.admin.doctor;

import org.example.repositories.DoctorRepository;
import org.example.repositories.PatientRepository;

import javax.servlet.http.HttpServletRequest;

public class DeleteDoctorAdminService {
    private DoctorRepository doctorRepository;

    public DeleteDoctorAdminService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void deleteDoctor(HttpServletRequest req) {
        Long id = Long.valueOf(req.getParameter("iddelete"));
        doctorRepository.deleteDoctorById(id);
    }
}
