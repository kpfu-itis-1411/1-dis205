package ru.kpfu.itis.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visit")
public class BookingServlet extends HttpServlet {
    private long getServiceId(String serviceName) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{ connection = getConnection();
            statement = connection.prepareStatement("SELECT id FROM service WHERE name = ?");
            statement.setString(1, serviceName);
            resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getLong("id");
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }finally {
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
    private Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/manicureservic", "postgres", "357706");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Failed to load PostgreSQL driver", e);
        }
    }
    private void addVisitToDatabase(long userId, long serviceId, java.sql.Timestamp purchasedate) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement("INSERT INTO visits (service_id,client_id, purchasedate) VALUES (?, ?, ?)");
            statement.setLong(1, serviceId);
            statement.setLong(2, userId);
            statement.setTimestamp(3, purchasedate);
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
    private boolean isDateValid(String date) {
        LocalDate selectedDate;
        try {
            selectedDate = LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            return false;
        }

        LocalDate currentDate = LocalDate.now();

        if (selectedDate.isBefore(currentDate) || selectedDate.isAfter(currentDate.plusDays(30))) {
            return false;
        }

        return true;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long clientid = (long) request.getSession().getAttribute("clientid");
        String service = request.getParameter("service");
        String date = request.getParameter("date");

        try {
            if (!isDateValid(date)) {
                request.setAttribute("message", "Invalid date format or date is not within 30 days from the current date!");
                request.getRequestDispatcher("/WEB-INF/view/record.jsp").forward(request, response);
            } else {
                long serviceId = getServiceId(service);
                java.sql.Timestamp purchasedate = java.sql.Timestamp.valueOf(LocalDate.parse(date).atStartOfDay());

                // Добавление записи о визите в базу данных
                addVisitToDatabase(clientid, serviceId, purchasedate);

                // Перенаправление на страницу успешной записи
                request.getRequestDispatcher("/WEB-INF/view/recordConfirmation.jsp").forward(request, response);
            }
        } catch (DateTimeParseException e) {
            request.setAttribute("message", "Incorrect date format!");
            request.getRequestDispatcher("/WEB-INF/view/record.jsp").forward(request, response);
        }
    }
}

