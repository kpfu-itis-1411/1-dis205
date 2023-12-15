package org.example.service.admin.appointment;

import org.example.repositories.AppointmentRepository;

import javax.servlet.http.HttpServletRequest;

public class DeleteAppointmentAdminService {
    private AppointmentRepository appointmentRepository;

    public DeleteAppointmentAdminService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void deleteAppointment(HttpServletRequest req) {
        Long id = Long.valueOf(req.getParameter("iddelete"));
        appointmentRepository.deleteAppointmentById(id);
    }
}
