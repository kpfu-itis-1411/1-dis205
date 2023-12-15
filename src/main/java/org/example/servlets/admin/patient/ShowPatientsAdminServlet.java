package org.example.servlets.admin.patient;

import org.example.service.admin.appointment.ShowAppointmentsAdminService;
import org.example.service.admin.patient.ShowPatientsAdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showPatientsAdmin")
public class ShowPatientsAdminServlet extends HttpServlet {
    private ShowPatientsAdminService showPatientsAdminService;

    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        showPatientsAdminService = (ShowPatientsAdminService) context.getAttribute("showPatientsAdminService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showPatientsAdminService.showPatients(req);
        req.getRequestDispatcher("show_patients_admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/show_patients_admin.jsp");
        requestDispatcher.forward(req, resp);
    }
}