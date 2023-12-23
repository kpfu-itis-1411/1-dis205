package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public static Connection createConnection(){
        String url = "jdbc:postgresql://localhost:5433/project_db";
        String username = "postgres";
        String password = "123456";

        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Работает прошлое подключение");
                return connection;

            } else {
                try {
                    Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Создан новый объект подключения " + connection);
                return connection;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void destroyConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                connection = null;
                System.out.println("Подключение закрыто");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}