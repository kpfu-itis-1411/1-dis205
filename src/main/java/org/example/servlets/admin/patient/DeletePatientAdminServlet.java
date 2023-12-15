package org.example.servlets.admin.patient;

import org.example.service.admin.appointment.DeleteAppointmentAdminService;
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
@WebServlet("/deletePatientAdmin")
public class DeletePatientAdminServlet extends HttpServlet {
    private DeletePatientAdminService deletePatientAdminService;

    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        deletePatientAdminService = (DeletePatientAdminService) context.getAttribute("deletePatientAdminService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/delete_patient_admin.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        deletePatientAdminService.deletePatient(req);

        resp.sendRedirect("http://localhost:8080/SemestrWork1/personalAccount");
    }
}


