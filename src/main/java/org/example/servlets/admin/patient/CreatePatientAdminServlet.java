package org.example.servlets.admin.patient;

import org.example.service.admin.patient.CreatePatientAdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/createPatientAdmin")
public class CreatePatientAdminServlet extends HttpServlet {
    private CreatePatientAdminService createPatientAdminService;

    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        createPatientAdminService = (CreatePatientAdminService) context.getAttribute("createPatientAdminService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/create_patient_admin.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        createPatientAdminService.createPatient(req);

        resp.sendRedirect("http://localhost:8080/SemestrWork1/personalAccount");
    }

}
