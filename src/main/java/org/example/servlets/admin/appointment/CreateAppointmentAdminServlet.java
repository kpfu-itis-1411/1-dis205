package org.example.servlets.admin.appointment;

import org.example.service.admin.appointment.CreateAppointmentAdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createAppointmentAdmin")
public class CreateAppointmentAdminServlet extends HttpServlet {
   private CreateAppointmentAdminService createAppointmentAdminService;

   public void init(ServletConfig config) throws ServletException {
      ServletContext context = config.getServletContext();
      createAppointmentAdminService = (CreateAppointmentAdminService) context.getAttribute("createAppointmentAdminService");
   }

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      RequestDispatcher requestDispatcher = req.getRequestDispatcher("/create_appointment_admin.jsp");
      requestDispatcher.forward(req, resp);
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      createAppointmentAdminService.createAppointment(req);

      resp.sendRedirect("http://localhost:8080/SemestrWork1/personalAccount");
   }
}
