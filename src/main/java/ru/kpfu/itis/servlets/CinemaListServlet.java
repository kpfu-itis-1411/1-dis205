package ru.kpfu.itis.servlets;

import ru.kpfu.itis.models.Cinema;
import ru.kpfu.itis.service.CinemaService;

import javax.servlet.http.HttpServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/movies")
public class CinemaListServlet extends HttpServlet {
    private CinemaService cinemaService = new CinemaService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cinema> movies = cinemaService.getAllCinema();
        request.setAttribute("movies", movies);
        request.getRequestDispatcher("/WEB-INF/view/cinema/list.jsp").forward(request, response);
        System.out.println(movies);
    }
}
