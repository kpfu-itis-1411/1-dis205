package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Anime;
import models.User;
import service.UserService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private UserService userService = new UserService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userLogin = (String) session.getAttribute("user_login");
		User user;

		try {
			user = userService.getUserByLogin(userLogin);
			List <Anime> userAnimeList = userService.getUserAnimeList(userLogin);

			request.setAttribute("userInfo", user);
			request.setAttribute("userAnimeList", userAnimeList);
			request.getRequestDispatcher("profile.ftl").forward(request, response);
		} catch (SQLException | ServletException | IOException e) {
			throw new RuntimeException(e);
		}
	}

//	public void doPost(HttpServletRequest request, HttpServletResponse response) {
//		HttpSession session = request.getSession();
//		try {
//			User user = userService.getUserByLogin((String) session.getAttribute("user_login"));
//			user.setUsername(request.getParameter("new_username"));
//			user.setEmail(request.getParameter("new_email"));
//			user.setPassword(request.getParameter("new_password"));
//
//			userService.update(user);
//			response.sendRedirect(request.getContextPath() + "/profile");
//		} catch (SQLException | IOException e) {
//			throw new RuntimeException(e);
//		}
//	}
}
