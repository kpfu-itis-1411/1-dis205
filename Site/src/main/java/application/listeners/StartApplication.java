package application.listeners;

import application.service.AvatarService;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import application.repository.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebListener
public class StartApplication implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("start app ");
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
