package org.example.servlets;

import org.example.service.PersonalAccountService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/personalAccount")
public class PersonalAccountServlet extends HttpServlet {

    private PersonalAccountService personalAccountService;

    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        personalAccountService = (PersonalAccountService) context.getAttribute("personalAccountService");
    }

//    PatientRepository patientRepository = new PatientRepository("jdbc:postgresql://localhost:5432/dentalclinic", "postgres", "postgres");
//    DoctorRepository doctorRepository = new DoctorRepository("jdbc:postgresql://localhost:5432/dentalclinic", "postgres", "postgres");



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        if (doctorRepository.findDoctorByEmail((String)request.getAttribute("email")) != null) {
//            Doctor doctor = doctorRepository.findDoctorByEmail((String)request.getAttribute("email"));
//            request.setAttribute("doctor1", doctor);
//
//        } else if (patientRepository.findPatientByEmail((String)request.getAttribute("email")) != null) {
//            Patient patient = patientRepository.findPatientByEmail((String)request.getAttribute("email"));
//            request.setAttribute("patient1", patient);
//        }

       personalAccountService.setAttributesForPersonalAccount(request);


        request.getRequestDispatcher("/personal_account.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

 //       personalAccountService.setAttributesForPersonalAccount(req);
    }

}