package org.example.service;

import org.example.exeptions.DoctorOrAdminNotFoundException;
import org.example.exeptions.PatientNotFoundException;
import org.example.models.Appointment;
import org.example.models.Doctor;
import org.example.models.Patient;
import org.example.repositories.AppointmentRepository;
import org.example.repositories.DoctorRepository;
import org.example.repositories.PatientRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public class PatientAppointmentsListService {
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    public PatientAppointmentsListService(PatientRepository patientRepository, AppointmentRepository appointmentRepository) {
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public void findAppointmentsByPatient(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("email");
        System.out.println(email);

        Patient patient = patientRepository.findPatientByEmail(email).orElseThrow(PatientNotFoundException::new);
        System.out.println(patient);

        List<Appointment> appointments = appointmentRepository.findAppointmentsByPatientId(patient.getId()).stream().toList();


        req.setAttribute("patient", patient);
        req.setAttribute("appointmentspatient", appointments);
    }
}
