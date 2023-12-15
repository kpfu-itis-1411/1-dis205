package org.example.service.admin.appointment;

import org.example.models.Appointment;
import org.example.models.Patient;
import org.example.repositories.AppointmentRepository;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class CreateAppointmentAdminService {
    private AppointmentRepository appointmentRepository;

    public CreateAppointmentAdminService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void createAppointment(HttpServletRequest req) {
        String procedureName = req.getParameter("procedurename");
        String appointmentDate = req.getParameter("appointmentdate");
        Long doctorId = Long.parseLong(req.getParameter("doctorid"));
        Long patientId = Long.parseLong(req.getParameter("patientid"));

        Appointment appointment = Appointment.builder()
                .name(procedureName)
                .appointmentDate(appointmentDate)
                .doctorId(doctorId)
                .patientId(patientId)
                .build();
        System.out.println(appointment);

        appointmentRepository.saveAppointment(appointment);
    }
}
