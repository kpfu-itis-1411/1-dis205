package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Training;
import service.ClientService;
import service.TrainingService;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
@WebServlet("/trainings")
public class TrainingsServlet extends HttpServlet {

    private TrainingService trainingService;

    @Override
    public void init() throws ServletException {
        super.init();
        trainingService = (TrainingService) getServletContext().getAttribute("TrainingService");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trainingIdParam = req.getParameter("trainingId");
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
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dateParam = req.getParameter("date");

        LocalDate date = (dateParam != null && !dateParam.isEmpty()) ? LocalDate.parse(dateParam) : LocalDate.now();
        List<Training> trainings = trainingService.getTrainingByDate(Date.valueOf(date));

        req.setAttribute("trainings", trainings);
        req.getRequestDispatcher("trainings.ftl").forward(req, resp);
    }
}