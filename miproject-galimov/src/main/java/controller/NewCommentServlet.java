package controller;

import DAO.CommentDao;
import DAO.PostDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Comment;
import model.NewPost;

import java.io.IOException;
import java.util.List;
/*
* Этот сервлет нужен для отображения страницы создания нового комментария
* и для сохранения нового комментария в бд
*
* */
public class NewCommentServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("homepage.ftl").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        String user_login = (String)session.getAttribute("userlogin");
        int postId = (int) session.getAttribute("postId");
        String comment_content = request.getParameter("comment");

        CommentDao commentDao = new CommentDao();
        Comment comment = new Comment();
        comment.setUser_login(user_login);
        comment.setPost_id(postId);
        comment.setContent(comment_content);
        String commSendStatus = commentDao.sendCommentToDb(comment);

        if(commSendStatus.equals("SUCCESS")) {
            response.sendRedirect(request.getContextPath()+"/commentPage?postId="+postId);
        }
        }
    }

