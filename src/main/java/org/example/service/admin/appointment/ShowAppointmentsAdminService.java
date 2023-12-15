package org.example.service.admin.appointment;

import org.example.models.Appointment;
import org.example.repositories.AppointmentRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowAppointmentsAdminService {
    private AppointmentRepository appointmentRepository;

    public ShowAppointmentsAdminService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    public void showAppointments(HttpServletRequest req) {
        List<Appointment> appointments = appointmentRepository.findAllAppointments().stream().toList();

        req.setAttribute("appointmentsadmin", appointments);

    }
}
