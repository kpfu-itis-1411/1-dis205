package ru.kpfu.itis.servlet.security;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.kpfu.itis.servlet.models.User;
import ru.kpfu.itis.servlet.service.UserService;


import java.io.IOException;
import java.util.Optional;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = (UserService) getServletContext().getAttribute("UserService");
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("registrationpage.ftl").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (!validateUsername(username)) {
            HttpSession session = request.getSession();
            session.setAttribute("error", "This login is already in use, or you entered an empty login");
            response.sendRedirect(request.getContextPath() + "/registration");
            return;
        }

        User user = new User();
        user.setEmail(email);
        user.setUserName(username);
        user.setPassword(password);

        userService.saveUser(user);

        HttpSession session = request.getSession();

        session.setAttribute("Username", user.getUserName());
        session.setAttribute("Userid", user.getUser_id());

        response.sendRedirect("./login");
    }

    private boolean validateUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            return false;
        }
        Optional<User> existingUser = userService.findByUsername(username);
        return existingUser.isEmpty();
    }


}


