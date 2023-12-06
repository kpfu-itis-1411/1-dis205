package application.listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import application.repository.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

@WebListener
public class StartApplication implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
//        ImageService imageService = new ImageService();
//        try {
//            imageService.saveAvatarUrl(1L, "/Users/danil/IdeaProjects/Semester_Work_1/Site/src/main/webapp/resources/img/avatars/default_avatar.jpg" );
//        } catch (SQLException | IOException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("start app ");
        try {
            DBConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("stop app ");
        DBConnection.getInstance().destroyConnection();
    }
}
