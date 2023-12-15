package org.example.servlets.admin.doctor;

import org.example.service.admin.doctor.UpdateDoctorAdminService;
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
@WebServlet("/updateDoctorAdmin")
public class UpdateDoctorAdminServlet extends HttpServlet {
    private UpdateDoctorAdminService updateDoctorAdminService;

    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        updateDoctorAdminService = (UpdateDoctorAdminService) context.getAttribute("updateDoctorAdminService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/update_doctor_admin.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        updateDoctorAdminService.updateDoctor(req);

        resp.sendRedirect("http://localhost:8080/SemestrWork1/personalAccount");
    }
}

