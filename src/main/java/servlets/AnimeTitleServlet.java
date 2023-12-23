package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Anime;
import service.AnimeService;
import service.UserService;

import java.io.IOException;

@WebServlet("/animeTitleInfo")
public class AnimeTitleServlet extends HttpServlet {
	private AnimeService animeService = new AnimeService();
	private UserService userService = new UserService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			String animeId = request.getParameter("anime_id");
			if (animeId == null || animeId.isEmpty()) {
				response.sendRedirect("errorPage");
			}

			long id = Long.parseLong(animeId);
			Anime anime = animeService.getAnimeById(id);
			request.setAttribute("animeInfo", anime);
			session.setAttribute("anime_id", id);

			boolean addStatus = userService.isAnimeAlreadyAddedToUser((Long) session.getAttribute("user_id"), (Long) session.getAttribute("anime_id"));
			request.setAttribute("alreadyAdded", addStatus);
			request.getRequestDispatcher("animeTitle.ftl").forward(request, response);
		} catch (NumberFormatException | ServletException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			Long user_id = (Long) session.getAttribute("user_id");
			Long anime_id = (Long) session.getAttribute("anime_id");
			if (anime_id == null || user_id == null) {
				response.sendRedirect("errorPage");
			}

			boolean flag = userService.addAnimeToUser(user_id, anime_id);
			if(flag) {
				response.sendRedirect("mainPage");
			} else {
				response.sendRedirect("errorPage");
			}
		} catch (NumberFormatException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}
