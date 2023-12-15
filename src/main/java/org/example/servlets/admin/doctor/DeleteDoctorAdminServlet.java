package org.example.servlets.admin.doctor;

import org.example.service.admin.doctor.DeleteDoctorAdminService;
import org.example.service.admin.patient.DeletePatientAdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/deleteDoctorAdmin")
public class DeleteDoctorAdminServlet extends HttpServlet {
    private DeleteDoctorAdminService deleteDoctorAdminService;

    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        deleteDoctorAdminService = (DeleteDoctorAdminService) context.getAttribute("deleteDoctorAdminService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/delete_doctor_admin.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        deleteDoctorAdminService.deleteDoctor(req);

        resp.sendRedirect("http://localhost:8080/SemestrWork1/personalAccount");
    }
}



