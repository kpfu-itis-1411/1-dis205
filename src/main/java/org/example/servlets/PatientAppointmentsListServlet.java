package org.example.servlets;

import org.example.service.PatientAppointmentsListService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patientProcedureList")
public class PatientAppointmentsListServlet extends HttpServlet {
    private PatientAppointmentsListService patientAppointmentsListService;

    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        patientAppointmentsListService = (PatientAppointmentsListService) context.getAttribute("patientAppointmentsListService");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        patientAppointmentsListService.findAppointmentsByPatient(req);
        req.getRequestDispatcher("patient_appointments_list.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/patient_appointments_list.jsp");
        requestDispatcher.forward(req, resp);
    }

}
