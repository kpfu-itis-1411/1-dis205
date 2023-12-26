package ru.kpfu.itis.servlet.servlets;

import ru.kpfu.itis.servlet.models.User;
import ru.kpfu.itis.servlet.repository.UserRepository;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.kpfu.itis.servlet.repository.UserRepositoryImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserRepository userRepository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("login.ftl").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        userRepository = new UserRepositoryImpl();

        String username = request.getParameter("username");
        String password = request.getParameter("password");


        Optional<User> userOptional = userRepository.getUserByUsername(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get();


            if (user.getPassword().equals(password)) {

                request.getSession().setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "/noteList");
            } else {
                response.sendRedirect(request.getContextPath() + "/login?error=invalid_credentials");
            }
        } else {

            response.sendRedirect(request.getContextPath() + "/login?error=user_not_found");
        }
    }
}