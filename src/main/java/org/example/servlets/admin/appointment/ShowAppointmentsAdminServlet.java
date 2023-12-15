package org.example.servlets.admin.appointment;

import org.example.service.admin.appointment.ShowAppointmentsAdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showAppointmentsAdmin")
public class ShowAppointmentsAdminServlet extends HttpServlet {
    private ShowAppointmentsAdminService showAppointmentsAdminService;

    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        showAppointmentsAdminService = (ShowAppointmentsAdminService) context.getAttribute("showAppointmentsAdminService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showAppointmentsAdminService.showAppointments(req);
        req.getRequestDispatcher("show_appointments_admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/show_appointments_admin.jsp");
        requestDispatcher.forward(req, resp);
    }
}
