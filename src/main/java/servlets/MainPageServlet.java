package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Anime;
import models.Genre;
import service.AnimeService;
import service.GenreService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/mainPage")
public class MainPageServlet extends HttpServlet {
	private AnimeService animeService = new AnimeService();
	private GenreService genreService = new GenreService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			List<Genre> genreList = genreService.getAllGenres();
			List<Anime> animeList;

			String selectedGenre = request.getParameter("genre");
			if (selectedGenre == null || selectedGenre.isEmpty()) {
				animeList = animeService.getAllAnime();
			} else {
				animeList = animeService.getAnimeByGenreName(selectedGenre);
			}

			session.removeAttribute("anime_id");
			request.setAttribute("genres", genreList);
			request.setAttribute("animelist", animeList);

			request.getRequestDispatcher("mainPage.ftl").forward(request,response);
		} catch (SQLException | ServletException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}
