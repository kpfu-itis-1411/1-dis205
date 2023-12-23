package controller;

import DAO.PostDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.NewPost;

import java.io.IOException;
import java.util.List;

public class MyPostPageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        String userLogin = (String) session.getAttribute("userlogin");

        PostDao postDao = new PostDao();
        List<NewPost> myPostList = postDao.findAllMyPosts(userLogin);
        session.setAttribute("myposts", myPostList);
        request.getRequestDispatcher("mypost.ftl").forward(request,response);
    }
}
