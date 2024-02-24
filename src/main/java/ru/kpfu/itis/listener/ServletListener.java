package ru.kpfu.itis.listener;

import ru.kpfu.itis.repository.DBConnection;
import ru.kpfu.itis.service.CinemaScoreService;
import ru.kpfu.itis.service.CinemaService;
import ru.kpfu.itis.service.ViewerService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletListener implements ServletContextListener {

    private DBConnection dbConnection;

    public void contextInitialized(ServletContextEvent sce) {
        DBConnection dbConnection = DBConnection.getInstance();
        sce.getServletContext().setAttribute("СinemaService",new CinemaService() );
        sce.getServletContext().setAttribute("CinemaScoreService", new CinemaScoreService());
        sce.getServletContext().setAttribute("ViewerService",new ViewerService());
    }

    public void contextDestroyed(ServletContextEvent sce) {
        dbConnection.destroyConnection();
    }
}
