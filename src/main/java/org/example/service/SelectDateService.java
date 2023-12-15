package org.example.service;

import org.example.exeptions.PatientNotFoundException;
import org.example.exeptions.ProcedureNotFoundException;
import org.example.models.Appointment;
import org.example.models.TimeSlot;
import org.example.repositories.AppointmentRepository;
import org.example.repositories.PatientRepository;
import org.example.repositories.ProcedureRepository;
import org.example.repositories.TimeSlotRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SelectDateService {
    private final AppointmentRepository appointmentRepository;
    private final ProcedureRepository procedureRepository;
    private final PatientRepository patientRepository;
    private final TimeSlotRepository timeSlotRepository;

    public SelectDateService(AppointmentRepository appointmentRepository, ProcedureRepository procedureRepository, PatientRepository patientRepository, TimeSlotRepository timeSlotRepository) {
        this.appointmentRepository = appointmentRepository;
        this.procedureRepository = procedureRepository;
        this.patientRepository = patientRepository;
        this.timeSlotRepository = timeSlotRepository;
    }

    public void findTimeSlots(HttpServletRequest req) {
        String procedureNameFromForm = req.getParameter("name");
        System.out.println(procedureNameFromForm);
        List<String> timeSlots = timeSlotRepository.findAllTimeSlotsByProcedureName(procedureNameFromForm)
                .stream().map(TimeSlot::getFreeTime).toList();

        req.setAttribute("timeSlots", timeSlots);

        System.out.println(timeSlots);
    }

    public String saveAppointments(HttpServletRequest reg){

        String procedureName = reg.getParameter("name");

        String appointmentDate = reg.getParameter("date");

        Long doctorId = procedureRepository.findDoctorIdByProcedureName(procedureName)
                .orElseThrow(ProcedureNotFoundException::new);

        String patientEmail = (String) reg.getAttribute("email");

        Long patientId = patientRepository.findPatientIdByEmail(patientEmail)
                .orElseThrow(PatientNotFoundException::new);
       // System.out.println(patientId);


        Appointment appointment = Appointment.builder()
                .name(procedureName)
                .appointmentDate(appointmentDate)
                .doctorId(doctorId)
                .patientId(patientId)
                .build();


        if (procedureName != null && appointmentDate!= null && doctorId != null && patientId != null) {
            appointmentRepository.saveAppointment(appointment);
            System.out.println("appointment saved");
            timeSlotRepository.deleteTimeSlotByProcedureAndFreeTime(procedureName, appointmentDate);
            System.out.println("time slot deleted");
            String destinationPage = "/SemestrWork1/success.jsp";
            return destinationPage;
            //resp.sendRedirect(destinationPage);
        } else {
            System.out.println("appointment doesn't saved");
            String destinationPage = "/SemestrWork1/error.jsp";
            return destinationPage;
            //resp.sendRedirect(destinationPage);
        }
    }
}
