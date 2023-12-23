package ru.kpfu.itis.servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private boolean checkUserExistence(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement("SELECT COUNT(*) FROM client WHERE name = ?");
            statement.setString(1, name);
            resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void addClientToDatabase(String name, String phoneNumber, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement("INSERT INTO client (name, phonenumber, password) VALUES (?, ?, ?)");
            statement.setString(1, name);
            statement.setString(2, phoneNumber);
            statement.setString(3, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/manicureservic", "postgres", "357706");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Failed to load PostgreSQL driver", e);
        }
}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phone");
        String password = request.getParameter("password");

        // Проверка наличия дубликатов пользователя
        if (checkUserExistence(name)) {
            request.setAttribute("message", "A user with that name already exists!");
            request.getRequestDispatcher("/WEB-INF/view/regpage.jsp").forward(request, response);
        } else {
            // Добавление пользователя в базу данных
            addClientToDatabase(name, phoneNumber, password);

            // Перенаправление на страницу успешного добавления
            response.sendRedirect("/manicure/record");
        }
    }
}