package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.Comments;
import org.example.repository.OtzivRepository;

import java.io.IOException;
import java.util.List;

@WebServlet("/OtzivShow")
public class OtzivPageServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postIdString = request.getParameter("postId");
        HttpSession session = request.getSession(false);

        int postId = Integer.parseInt(postIdString);
        session.setAttribute("postId",postId);

        OtzivRepository commentDao = new OtzivRepository();
        List<Comments> comments = commentDao.findAllComments(postId);
        request.setAttribute("comments", comments);

        request.getRequestDispatcher("otzivShowing.ftl").forward(request,response);

    }
}