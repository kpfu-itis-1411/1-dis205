package org.example.service;

import org.example.models.Procedure;
import org.example.repositories.ProcedureRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CreateAppointmentService {
    private final ProcedureRepository procedureRepository;
    public CreateAppointmentService(ProcedureRepository procedureRepository) {
        this.procedureRepository = procedureRepository;
    }

    public void findProcedureNames(HttpServletRequest req) {
        List<String> procedureNames = procedureRepository.findAllProcedures().stream().map(Procedure::getName).toList();

        req.setAttribute("proceduresNames", procedureNames);
        System.out.println(procedureNames);
    }
}
