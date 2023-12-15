package org.example.service.admin.appointment;

import org.example.repositories.AppointmentRepository;

import javax.servlet.http.HttpServletRequest;

public class UpdateAppointmentAdminService {
    private AppointmentRepository appointmentRepository;

    public UpdateAppointmentAdminService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void updateAppointment(HttpServletRequest req) {
        Long id = Long.valueOf(req.getParameter("idupdate"));
        String procedureName = req.getParameter("procedurenameupdate");
        String appointmentDate = req.getParameter("appointmentdateupdate");
        Long doctorId = Long.parseLong(req.getParameter("doctoridupdate"));
        Long patientId = Long.parseLong(req.getParameter("patientidupdate"));

        appointmentRepository.updateAppointmentById(id, procedureName, appointmentDate, doctorId, patientId);
    }
}
