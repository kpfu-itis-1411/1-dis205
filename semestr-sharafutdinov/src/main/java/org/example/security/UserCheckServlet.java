package org.example.security;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.repository.UserRepository;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/usercheck")
public class UserCheckServlet extends HttpServlet {

    public void init(ServletConfig servletConfig) throws ServletException {

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserRepository userRepository = new UserRepository();
        boolean credentialsValid = userRepository.checkCredentials(login, password);

        if (credentialsValid) {
            HttpSession session = request.getSession();
            session.setAttribute("login", login);

            response.sendRedirect("/semestrWork_war/startPage");
        } else {
            request.setAttribute("message", "Неверный логин или пароль");
            request.getRequestDispatcher("/login.ftl").forward(request, response);
        }
//        if ("admin".equals(username) && "admin".equals(password)) {
//            HttpSession session = request.getSession();
//            session.setAttribute("username", username);
//            response.sendRedirect("/semestrWork_war/startPage");
//        } else {
//            request.setAttribute("message", "Неверный логин или пароль");
//            request.getRequestDispatcher("/login.ftl").forward(request, response);
//        }

    }

}
