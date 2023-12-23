package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import service.UserService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private UserService userService = new UserService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("registration.ftl").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password_repeat = request.getParameter("password_repeat");
		User user = new User();
		user.setLogin(login);
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		String regStatus;

		if (password.equals(password_repeat)) {
			try {
				if(userService.getUserByLogin(login) == null) {
					regStatus = userService.RegNewUser(user);

					switch (regStatus) {
						case "This email address already occupied" -> {
							request.setAttribute("errormessage", "Пользователь с такой почтой уже существует");
							request.getRequestDispatcher("registration.ftl").forward(request, response);
						}
						case "This login already occupied" -> {
							request.setAttribute("errormessage", "Пользователь с таким логином уже существует");
							request.getRequestDispatcher("registration.ftl").forward(request, response);
						}
						case "New user was registered" -> response.sendRedirect(request.getContextPath() + "/mainPage");
					}
				} else {
					request.setAttribute("errormessage", "Пользователь с этим логином или почтой уже существует");
					request.getRequestDispatcher("registration.ftl").forward(request, response);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		} else {
			request.setAttribute("errormessage", "Ваши пароли не совпадают");
			request.getRequestDispatcher("registration.ftl").forward(request, response);
		}
	}
}
