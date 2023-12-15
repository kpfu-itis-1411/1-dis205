package org.example.servlets.admin.patient;

import org.example.repositories.AppointmentRepository;
import org.example.repositories.PatientRepository;
import org.example.service.admin.appointment.UpdateAppointmentAdminService;
import org.example.service.admin.patient.UpdatePatientAdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/updatePatientAdmin")
public class UpdatePatientAdminServlet extends HttpServlet {
    private UpdatePatientAdminService updatePatientAdminService;

    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        updatePatientAdminService = (UpdatePatientAdminService) context.getAttribute("updatePatientAdminService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/update_patient_admin.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        updatePatientAdminService.updatePatient(req);

        resp.sendRedirect("http://localhost:8080/SemestrWork1/personalAccount");
    }
}
