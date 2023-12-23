package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/startPage")
public class StartPageServlet extends HttpServlet {
    public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String my_login = (String) session.getAttribute("login");

        request.setAttribute("login",my_login);
        request.getRequestDispatcher("startPage.ftl").forward(request, response);
    }
}
