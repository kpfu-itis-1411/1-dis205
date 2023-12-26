package listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import repository.DBConnection;
import service.ClientService;
import service.DisciplineService;
import service.TrainerService;
import service.TrainingService;

@WebListener
public class StartApplication implements ServletContextListener {

    private DBConnection dbConnection;

    public void contextInitialized(ServletContextEvent sce) {
        DBConnection dbConnection = DBConnection.getInstance();
        sce.getServletContext().setAttribute("ClientService",new ClientService());
        sce.getServletContext().setAttribute("DisciplineService",new DisciplineService());
        sce.getServletContext().setAttribute("TrainerService",new TrainerService());
        sce.getServletContext().setAttribute("TrainingService",new TrainingService());
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("stop app ");
        dbConnection.destroyConnection();
    }

}