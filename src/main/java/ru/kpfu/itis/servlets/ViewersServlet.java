package ru.kpfu.itis.servlets;

import ru.kpfu.itis.repository.ViewerRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/viewers")
public class ViewersServlet extends HttpServlet {
    private ViewerRepository viewerRepository;

    @Override
    public void init() throws ServletException{}
}
