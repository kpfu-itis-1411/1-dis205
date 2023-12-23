package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;
import service.UserService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/usercheck")
public class UsercheckServlet extends HttpServlet {
	private UserService userService = new UserService();

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		User user;

		try {
			user = userService.getUserByLogin(login);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		if (user != null && user.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("user_id", user.getId());
			session.setAttribute("user_login", user.getLogin());
			response.sendRedirect(request.getContextPath() + "/mainPage");
		} else {
			request.setAttribute("errormessage", "Неверный логин или пароль");
			request.getRequestDispatcher("login.ftl").forward(request, response);
		}
	}
}
