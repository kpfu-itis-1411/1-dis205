package ru.kpfu.itis.servlets;

import ru.kpfu.itis.models.Cinema;
import ru.kpfu.itis.service.CinemaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/movie/*")
public class CinemaDetailsServlet extends HttpServlet {
    private CinemaService cinemaService = new CinemaService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        // Извлекаем id фильма из URL
        String[] pathParts = pathInfo.split("/");
        if (pathParts.length != 2) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        int movieId;
        try {
            movieId = Integer.parseInt(pathParts[1]);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        System.out.println(movieId);
        List<Cinema> movies = cinemaService.getAllCinema();
        Cinema cinema = cinemaService.getById(movieId);
        if(cinema != null) {
            request.setAttribute("title", cinema.getTitle());
            request.setAttribute("desc", cinema.getDescription());
            request.setAttribute("director", cinema.getDirector());
            request.setAttribute("issue", cinema.getYear());
            request.setAttribute("id", movieId);
            request.getRequestDispatcher("/WEB-INF/view/movie.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("/WEB-INF/view/page_not_found.jsp").forward(request, response);
        }

    }

}
