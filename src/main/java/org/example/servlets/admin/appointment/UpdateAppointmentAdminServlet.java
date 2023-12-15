package org.example.servlets.admin.appointment;

import org.example.service.admin.appointment.UpdateAppointmentAdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateAppointmentAdmin")
public class UpdateAppointmentAdminServlet extends HttpServlet {

    private UpdateAppointmentAdminService updateAppointmentAdminService;

    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        updateAppointmentAdminService = (UpdateAppointmentAdminService) context.getAttribute("updateAppointmentAdminService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/update_appointment_admin.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        updateAppointmentAdminService.updateAppointment(req);

        resp.sendRedirect("http://localhost:8080/SemestrWork1/personalAccount");
    }
}
