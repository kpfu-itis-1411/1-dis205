package org.example.servlets;

import org.example.service.DoctorAccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doctorProcedureList")
public class DoctorAccountServlet extends HttpServlet {

    private DoctorAccountService doctorAccountService;

    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        doctorAccountService = (DoctorAccountService) context.getAttribute("doctorAccountService");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doctorAccountService.findAppointmentsByDoctor(req);

// //       HttpSession session = req.getSession();
//        String email = (String) session.getAttribute("email");
//
//        DoctorRepository doctorRepository = new DoctorRepository();
//        Doctor doctor = doctorRepository.findDoctorByEmail(email);
//
//        AppointmentRepository appointmentRepository = new AppointmentRepository();
//        List<Appointment> appointments = appointmentRepository.findAppointmentsByDoctorId(doctor.getId());
//
//        req.setAttribute("doctor", doctor);
//        req.setAttribute("appointments", appointments);
//            req.getRequestDispatcher("doctor.jsp").forward(req, resp);

               req.getRequestDispatcher("doctor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/doctor.jsp");
        requestDispatcher.forward(req, resp);
    }
}
