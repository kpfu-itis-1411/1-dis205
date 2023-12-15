package org.example.servlets;

import org.example.models.Procedure;
import org.example.service.CreateAppointmentService;
import org.example.service.SingInService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/createAppointment")
public class CreateAppointmentServlet extends HttpServlet {
        private CreateAppointmentService createAppointmentService;

        public void init(ServletConfig config) throws ServletException {
                ServletContext context = config.getServletContext();
                createAppointmentService = (CreateAppointmentService) context.getAttribute("createAppointmentService");
        }

        private static final long serialVersionUID = 1L;
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//                List<String> procedureNames = ProcedureRepository.findAll().stream().map(Procedure::getName).toList();
//                req.setAttribute("proceduresNames", procedureNames);
//                System.out.println(procedureNames);
                createAppointmentService.findProcedureNames(req);
                req.getRequestDispatcher("/create_appointment.jsp").forward(req, resp);

        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


                String destinationPage = "/SemestrWork1/selectDate?name=" + req.getParameter("name");
                resp.sendRedirect(destinationPage);
        }
}




















