package ru.kpfu.itis.repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            return connection;
        } else {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            Connection connection =
                    DriverManager.getConnection(
                            // адрес БД , имя пользователя, пароль
                            "jdbc:postgresql://localhost:5432/manicureservic?characterEncoding=UTF-8","postgres","357706");
            return connection;
        }
    }

    public static void destroyConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}