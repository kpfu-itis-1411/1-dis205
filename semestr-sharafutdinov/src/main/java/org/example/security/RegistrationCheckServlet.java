package org.example.security;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.UserForRegister;
import org.example.repository.UserRepository;
import org.example.service.UserService;
//import org.example.model.UserForRegister;
//import org.example.service.UserService;

import java.io.IOException;

@WebServlet("/regpage")
public class RegistrationCheckServlet extends HttpServlet {

    public void init(ServletConfig servletConfig) throws ServletException {

    }

    private UserService userService = new UserService();
    private UserRepository userRepository = new UserRepository();
    private UserForRegister user = new UserForRegister();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String email = request.getParameter("email");
        String phone_number = request.getParameter("phone_number");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (userRepository.findByEmail(email) != null) {
            request.setAttribute("error", "Пользователь с таким email уже зарегистрирован");
            request.getRequestDispatcher("/registration.ftl").forward(request, response);
        } else if (userRepository.findByLogin(login) != null) {
            request.setAttribute("error", "Пользователь с таким логин уже зарегистрирован, выберите другой");
            request.getRequestDispatcher("/registration.ftl").forward(request, response);
        } else if (userRepository.findByPhoneNumber(phone_number) != null) {
            request.setAttribute("error", "Пользователь с таким номером телефона уже зарегистрирован");
            request.getRequestDispatcher("/registration.ftl").forward(request, response);
        } else {
            user.setEmail(email);
            user.setPhone_Number(phone_number);
            user.setLogin(login);
            user.setPassword(password);

            user = userService.save(user);
            HttpSession session = request.getSession();
            // храним в сессии данные для работы с бд
            session.setAttribute("id", user.getId());

//        // перенаправление на другую страничку
            response.sendRedirect("/semestrWork_war/startPage");
        }
    }
}
