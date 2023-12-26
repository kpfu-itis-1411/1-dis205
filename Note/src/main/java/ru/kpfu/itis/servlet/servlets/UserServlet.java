package ru.kpfu.itis.servlet.servlets;

import ru.kpfu.itis.servlet.models.User;
import ru.kpfu.itis.servlet.repository.UserRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private UserRepository userRepository;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("register".equals(action)) {
            handleRegistration(request, response);
        } else if ("login".equals(action)) {
            handleLogin(request, response);
        } else if ("logout".equals(action)) {
            handleLogout(request, response);
        } else {
            // Обработка некорректного действия
            response.sendRedirect(request.getContextPath() + "/login?error=invalid_action");
        }
    }

    private void handleRegistration(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");


        if (userRepository.getUserByUsername(username) == null) {
            // Создание нового пользователя
            User newUser = new User(username, password, email);
            userRepository.saveUser(newUser);

            request.login(username, password);

            response.sendRedirect(request.getContextPath() + "/note");
        } else {

            response.sendRedirect(request.getContextPath() + "/register?error=duplicate");
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Аутентификация пользователя
        try {
            request.login(username, password);

            response.sendRedirect(request.getContextPath() + "/note");
        } catch (ServletException e) {

            response.sendRedirect(request.getContextPath() + "/login?error=invalid");
        }
    }

    private void handleLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.logout();
        response.sendRedirect(request.getContextPath() + "/login");
    }
}
