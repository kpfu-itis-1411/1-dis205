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

public class SingInService {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private  final HashPasswordService hashPasswordService;

    public SingInService(DoctorRepository doctorRepository, PatientRepository patientRepository, HashPasswordService hashPasswordService) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.hashPasswordService = hashPasswordService;
    }
    public String authenticate(HttpServletRequest req) {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        String auth = authenticateUser(email, password);
        HttpSession session = req.getSession();
        session.setAttribute("role", auth);


        if (auth.equals("patient")) {
            Patient patient = patientRepository.findPatientByEmailAndPassword(email, hashPasswordService.encrypt(password)).orElseThrow(PatientNotFoundException::new);
            session.setAttribute("email", patient.getEmail());
        }

        if (auth.equals("doctor")) {
            Doctor doctor = doctorRepository.findDoctorByEmailAndPassword(email, password).orElseThrow(DoctorOrAdminNotFoundException::new);
            session.setAttribute("email", doctor.getEmail());
        }

        if (auth.equals("admin")) {
            Doctor doctor = doctorRepository.findDoctorByEmailAndPassword(email, password).orElseThrow(DoctorOrAdminNotFoundException::new);
            session.setAttribute("email", doctor.getEmail());
        }
        return auth;
    }

    private String authenticateUser(String username, String password) {

        String hashPassword = hashPasswordService.encrypt(password);
        Optional<Doctor> optionalDoctor = doctorRepository.findDoctorByEmailAndPassword(username, password);
        if (optionalDoctor.isPresent()) {
            if ("Admin".equals(optionalDoctor.get().getPost())) {
                return "admin";
            }
            return "doctor";
        }

        if (patientRepository.findPatientByEmailAndPassword(username, hashPassword).isPresent()) {
            return "patient";
        }
        return "error";
    }
}
