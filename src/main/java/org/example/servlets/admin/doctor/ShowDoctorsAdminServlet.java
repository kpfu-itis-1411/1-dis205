package org.example.servlets.admin.doctor;

import org.example.service.admin.doctor.ShowDoctorsAdminService;
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
@WebServlet("/showDoctorsAdmin")
public class ShowDoctorsAdminServlet extends HttpServlet {
    private ShowDoctorsAdminService showDoctorsAdminService;

    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        showDoctorsAdminService = (ShowDoctorsAdminService) context.getAttribute("showDoctorsAdminService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showDoctorsAdminService.showDoctors(req);
        req.getRequestDispatcher("show_doctors_admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/show_doctors_admin.jsp");
        requestDispatcher.forward(req, resp);
    }
}
