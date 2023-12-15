package org.example.service;

import org.example.exeptions.DoctorOrAdminNotFoundException;
import org.example.models.Appointment;
import org.example.models.Doctor;
import org.example.repositories.AppointmentRepository;
import org.example.repositories.DoctorRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class DoctorAccountService {
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;

    public DoctorAccountService(DoctorRepository doctorRepository, AppointmentRepository appointmentRepository) {
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public void findAppointmentsByDoctor(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("email");

        Doctor doctor = doctorRepository.findDoctorByEmail(email).orElseThrow(DoctorOrAdminNotFoundException::new);

        List<Appointment> appointments = appointmentRepository.findAppointmentsByDoctorId(doctor.getId()).stream().toList();

        req.setAttribute("doctor", doctor);
        req.setAttribute("appointments", appointments);
    }
}
