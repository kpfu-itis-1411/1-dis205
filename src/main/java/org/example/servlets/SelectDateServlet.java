package org.example.servlets;

import org.example.service.SelectDateService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectDate")
public class SelectDateServlet extends HttpServlet {

    private SelectDateService selectDateService;

    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        selectDateService = (SelectDateService) context.getAttribute("selectDateService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String procedureNameFromForm = req.getParameter("name");
//        List<String> timeSlots = TimeSlotRepository.findAllProceduresByName(procedureNameFromForm)
//                .stream().map(TimeSlot::getFreeTime).toList();
//
//        req.setAttribute("timeSlots", timeSlots);
//
//        System.out.println(timeSlots);

        selectDateService.findTimeSlots(req);

        req.getRequestDispatcher("/select_date.jsp").forward(req, resp);


////        List<String> procedureNames = ProcedureRepository.findAll().stream().map(Procedure::getName).toList();
//        req.setAttribute("proceduresNames", procedureNames);

//        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/select_date.jsp");
//        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String destinationPage = selectDateService.saveAppointments(req);
        resp.sendRedirect(destinationPage);
    }
}


//        try (Connection connection = ConnectionContainer.getConnection()) {
//
//            String procedureName = req.getParameter("name");
//
//            String appointmentDate = req.getParameter("date");
//
//            Long doctorId = procedureRepository.getDoctorIdByProcedureName(procedureName);
//
//            String patientEmail = (String) req.getAttribute("email");
//
//            Long patientId = patientRepository.findPatientIdByEmail(patientEmail);
//            System.out.println(patientId);
//
//
//            Appointment appointment = Appointment.builder()
//                    .name(procedureName)
//                    .appointmentDate(appointmentDate)
//                    .doctorId(doctorId)
//                    .patientId(patientId)
//                    .build();
//
//
//            if (procedureName != null && appointmentDate!= null && doctorId != null && patientId != null) {
//                appointmentRepository.save(appointment);
//                System.out.println("appointment saved");
//                String destinationPage = "/SemestrWork1/success.jsp";
//                resp.sendRedirect(destinationPage);
//            } else {
//                System.out.println("appointment doesn't saved");
//                String destinationPage = "/SemestrWork1/error.jsp";
//                resp.sendRedirect(destinationPage);
//            }
//            //connection.isClosed();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
