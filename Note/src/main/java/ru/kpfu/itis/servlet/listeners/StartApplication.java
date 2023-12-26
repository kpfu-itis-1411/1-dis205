package ru.kpfu.itis.servlet.listeners;

import ru.kpfu.itis.servlet.repository.*;
import ru.kpfu.itis.servlet.service.NoteService;
import ru.kpfu.itis.servlet.service.UserService;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class StartApplication implements ServletContextListener {

    private DBConnection dbConnection;

    public void contextInitialized(ServletContextEvent sce) {

        DBConnection dbConnection = DBConnection.getInstance();
        System.out.println("DBConnection initialized");

        sce.getServletContext().setAttribute("NoteService", new NoteService());
        sce.getServletContext().setAttribute("UserService", new UserService());

        System.out.println("Services initialized");
    }

    public void contextDestroyed(ServletContextEvent sce) {

        if (dbConnection != null) {
            dbConnection.destroyConnection();
            System.out.println("DBConnection destroyed");
        }
    }
}
