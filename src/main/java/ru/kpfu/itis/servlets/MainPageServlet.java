package ru.kpfu.itis.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class MainPageServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // делаем внутреннюю переадресацию на jsp
        getServletContext().getRequestDispatcher("/WEB-INF/view/main.jsp").forward(req, resp);
    }
}
