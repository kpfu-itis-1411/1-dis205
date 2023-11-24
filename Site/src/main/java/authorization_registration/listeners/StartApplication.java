package authorization_registration.listeners;

import authorization_registration.service.ImageService;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import authorization_registration.repository.DBConnection;

import java.io.IOException;
import java.sql.SQLException;

@WebListener
public class StartApplication implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
//        ImageService imageService = new ImageService();
//        try {
//            imageService.saveImage(6L, "/Users/danil/IdeaProjects/Semester_Work_1/Site/src/main/webapp/resources/img/arseniy.jpg" );
//        } catch (SQLException | IOException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println("start app ");
        try {
            DBConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("stop app ");
        DBConnection.destroyConnection();
    }
}
