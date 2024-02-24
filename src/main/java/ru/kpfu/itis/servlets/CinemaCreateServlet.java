package ru.kpfu.itis.servlets;


import ru.kpfu.itis.models.Cinema;
import ru.kpfu.itis.service.CinemaService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/cinema/new")
public class CinemaCreateServlet extends HttpServlet {

    private CinemaService cinemaService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/create_cinema.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String director = request.getParameter("director");
        int year = Integer.parseInt(request.getParameter("year"));
        String description = request.getParameter("description");
        Cinema cinema = Cinema.builder()

                .title(title)
                .year(year)
                .description(description)
                .director(director)
                .build();
        cinemaService = new CinemaService();
        cinemaService.saveCinema(cinema);
        System.out.println(cinema.toString());
        getServletContext().getRequestDispatcher("/WEB-INF/view/create_cinema.jsp").forward(request, response);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        cinemaService = (CinemaService) getServletContext().getAttribute("cinemaService");
    }
}
