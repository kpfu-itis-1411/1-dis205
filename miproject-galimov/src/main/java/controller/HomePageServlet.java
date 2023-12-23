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
/*
Этот сервлет нам нужен для отображения домашней страницы и также для отображения всех постов
*/
public class HomePageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        PostDao postDao = new PostDao();
        List<NewPost> postList = postDao.findAllPosts();
        session.setAttribute("posts", postList);

        request.getRequestDispatcher("homepage.ftl").forward(request,response);

    }
}
