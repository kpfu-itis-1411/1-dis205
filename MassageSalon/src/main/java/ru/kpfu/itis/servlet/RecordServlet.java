package ru.kpfu.itis.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

@WebServlet("/record")
public class RecordServlet extends HttpServlet {

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/massageservice", "postgres", "King");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Failed to load PostgreSQL driver", e);
        }
    }
    private long getServiceId(String serviceName) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement("SELECT id FROM service WHERE name = ?");
            statement.setString(1, serviceName);
            resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getLong("id");
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
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

    private void addVisitToDatabase(long userId, long serviceId, java.sql.Timestamp purchasedate) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement("INSERT INTO visits (service_id, client_id, purchasedate) VALUES (?, ?, ?)");
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

    private boolean isDateTimeValid(String date, String time) {
        LocalDateTime selectedDateTime;//создание переменной выбранной даты
        try {
            LocalDate selectedDate = LocalDate.parse(date);
            LocalTime selectedTime = LocalTime.parse(time);
            selectedDateTime = LocalDateTime.of(selectedDate, selectedTime);
        } catch (DateTimeParseException e) {
            return false;
        }

        LocalDateTime currentDateTime = LocalDateTime.now();

        if (selectedDateTime.isBefore(currentDateTime) || selectedDateTime.isAfter(currentDateTime.plusDays(21))) {
            return false;
        }

        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(18, 0);

        if (selectedDateTime.toLocalTime().isBefore(startTime) || selectedDateTime.toLocalTime().isAfter(endTime)) {
            return false;
        }

        return true;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long clientId = (long) request.getSession().getAttribute("clientid");// берем из сессии
        String service = request.getParameter("service");//берем данные из формы
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        try {
            if (!isDateTimeValid(date, time)) {
                request.setAttribute("message", "Неверный формат даты или время или дата указана позднее 21 дня от сегодняшней даты или время не в диапазоне 8:00-18:00");
                request.getRequestDispatcher("/WEB-INF/view/record.jsp").forward(request, response);
            } else {
                long serviceId = getServiceId(service);
                LocalDateTime purchaseDateTime = LocalDateTime.of(LocalDate.parse(date), LocalTime.parse(time));
                java.sql.Timestamp purchasedate = java.sql.Timestamp.valueOf(purchaseDateTime);

                // Добавление записи о визите в базу данных
                addVisitToDatabase(clientId, serviceId, purchasedate);
                request.setAttribute("successMessage", "Запись успешно добавлена!");
                request.getRequestDispatcher("/WEB-INF/view/record.jsp").forward(request, response);
            }
        } catch (DateTimeParseException e) {
            request.setAttribute("message", "Неверный формат даты или время!");
            request.getRequestDispatcher("/WEB-INF/view/record.jsp").forward(request, response);
        }
    }
}