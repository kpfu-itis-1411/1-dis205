package org.example;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener
public class StartApplication implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("start app ");
        try {
            DBConnection.getConnection();
            System.out.println("cоздано подключени из слушателя");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("stop app ");
        DBConnection.destroyConnection();
    }
}