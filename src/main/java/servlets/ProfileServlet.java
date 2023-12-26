package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Client;
import model.Training;
import service.ClientService;
import service.TrainingService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private ClientService clientService;
    private TrainingService trainingService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        clientService = (ClientService) getServletContext().getAttribute("ClientService");
        trainingService = (TrainingService) getServletContext().getAttribute("TrainingService");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long clientId = (Long) req.getSession().getAttribute("clientid");
        Long trainingId = Long.valueOf(req.getParameter("trainingId"));
        if (clientId != null && trainingId != null) {
            trainingService.deleteFromClientTraining(clientId, trainingId);
            req.setAttribute("text", "Вы успешно отписались от тренировки");
        }
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long clientId = (Long) req.getSession().getAttribute("clientid");
        List<Training> trainingList;

        if (clientId != null) {
            Optional<Client> optionalClient = clientService.getClientById(Long.valueOf(clientId));
            if (optionalClient.isPresent()) {
                trainingList = trainingService.findByClientId(Long.valueOf(clientId));
                req.setAttribute("trainings", trainingList);
                req.setAttribute("client", optionalClient.get());
                req.getRequestDispatcher("profile.ftl").forward(req, resp);
            }
        }
    }
}
