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

@WebServlet("/usercheck")
public class UsercheckServlet extends HttpServlet {

    private UserService UserService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        UserService = (UserService) getServletContext().getAttribute("UserService");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Optional<User> UserOptional = UserService.findByUsername(username);
        if (UserOptional.isPresent()) {
            if ( UserOptional.get().getPassword().equals(password)) {

                HttpSession session = request.getSession();

                session.setAttribute("Username", UserOptional.get().getUserName());
                session.setAttribute("Userid", UserOptional.get().getUser_id());

                response.sendRedirect("./noteList");

            } else {
                request.setAttribute("message", "Incorrect password or login");
                request.getRequestDispatcher("login.ftl").forward(request, response);
            }
        }
    }

}
