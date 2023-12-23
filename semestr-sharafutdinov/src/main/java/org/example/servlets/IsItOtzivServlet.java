package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/Otziv")
public class IsItOtzivServlet extends HttpServlet {
    public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setAttribute("message", "");
        HttpSession session = request.getSession(false);

        String postIdString = request.getParameter("postId");
        int postId = Integer.parseInt(postIdString);

        session.setAttribute("postId", postId);

        request.getRequestDispatcher("headr.ftl").forward(request, response);
    }
}
