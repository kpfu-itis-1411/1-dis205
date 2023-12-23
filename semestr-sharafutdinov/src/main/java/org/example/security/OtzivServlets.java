package org.example.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/headr")
public class OtzivServlets extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        Connection connection = null;
        String login = (String) session.getAttribute("login");
        System.out.println("login" + "" + login);
        String comment = request.getParameter("comment");
        System.out.println("comment" + "" + comment);
        int postId = (int) session.getAttribute("postId");
        System.out.println("postIddddddd" + " " + postId);

        try {
            connection = DBConnection.getConnection();
            String sql = "INSERT INTO comments (post_id, text, author) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, postId);
            statement.setString(2, comment);
            statement.setString(3, login);

            statement.executeUpdate();

            statement.close();


            response.sendRedirect("/semestrWork_war/startPage");
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }
}