package org.example.service;

import org.example.exeptions.DoctorOrAdminNotFoundException;
import org.example.exeptions.PatientNotFoundException;
import org.example.models.Doctor;
import org.example.models.Patient;
import org.example.repositories.DoctorRepository;
import org.example.repositories.PatientRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class PersonalAccountService {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public PersonalAccountService(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public void setAttributesForPersonalAccount(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("email");
        System.out.println(email);
        Optional<Doctor> doctorOptional = doctorRepository.findDoctorByEmail(email);
        if (doctorOptional.isPresent()) {
            req.setAttribute("doctor1", doctorOptional.get());
        } else {
             patientRepository.findPatientByEmail(email)
                     .ifPresent(patient -> {
                         System.out.println(patient);
                         req.setAttribute("patient1", patient);
                     });
        }
    }
}
