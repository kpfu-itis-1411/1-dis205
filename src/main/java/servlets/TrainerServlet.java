package servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Trainer;
import model.Training;
import service.TrainerService;
import service.TrainingService;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@WebServlet("/trainer_profile")
public class TrainerServlet extends HttpServlet {

    private TrainerService trainerService;
    private TrainingService trainingService;

    @Override
    public void init() throws ServletException {
        super.init();
        trainingService = (TrainingService) getServletContext().getAttribute("TrainingService");
        trainerService = (TrainerService) getServletContext().getAttribute("TrainerService");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trainingIdParam = req.getParameter("trainingId");
        String trainerIdParam = req.getParameter("trainerId");
        Long clientId = (Long) req.getSession().getAttribute("clientid");
        if (trainingIdParam != null && !trainingIdParam.isEmpty()) {
            Long trainingId = Long.parseLong(trainingIdParam);
            boolean isRegistered = trainingService.getByClientTraining(clientId, trainingId);
            if (isRegistered) {
                req.setAttribute("isRegistered", false);
            } else {
                trainingService.register(clientId,trainingId);
                req.setAttribute("isRegistered", true);
            }
        }
        req.setAttribute("trainerId", trainerIdParam);
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trainerIdParam = req.getParameter("trainerId");
        if (trainerIdParam != null && !trainerIdParam.isEmpty()) {
            Long trainerId = Long.parseLong(trainerIdParam);
            Optional<Trainer> trainer = trainerService.getTrainerById(trainerId);
            List<Training> trainings = trainingService.getByTrainerId(trainerId);
            if (trainer.isPresent()) {
                req.setAttribute("trainer", trainer.get());
                req.setAttribute("trainings", trainings);
            }
        } else {
            List<Trainer> trainers = trainerService.getAllTrainers();
            req.setAttribute("trainers", trainers);
        }
        req.getRequestDispatcher("trainer_profile.ftl").forward(req, resp);
    }
}