package listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import repository.DBConnection;


@WebListener
public class StartApplication implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("start app ");
        System.out.println("Создано подключение из Слушателя :");
        DBConnection.createConnection();

    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("stop app ");
        DBConnection.destroyConnection();
    }
}