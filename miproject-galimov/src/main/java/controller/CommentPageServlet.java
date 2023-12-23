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
На страницу comments.ftl мы попадаем благодаря форме на странице homepage.ftl
<form action="commentPage" method="get">
         <input type="hidden" name="postId" value="${post.id}">
         <input type="submit" value="View Comments">
</form>
У каждого поста есть кнопка посмотреть комментарии, нажав на кнопку из формы, у нас
отправляются атрибуты запроса вместе с запросом - commentPage?postId=3, тк метод формы GET
Затем в методе doGet мы получаем значение id из запроса и получаем пост и все комментарии по этому id поста
*/
public class CommentPageServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postIdString = request.getParameter("postId");
        HttpSession session = request.getSession(false);

        int postId = Integer.parseInt(postIdString);
        session.setAttribute("postId",postId);

        PostDao postDao = new PostDao();
        NewPost newPost = postDao.findPostById(postId);
        request.setAttribute("postbyid",newPost);

        CommentDao commentDao = new CommentDao();
        List<Comment> comments = commentDao.findAllComments(postId);
        request.setAttribute("comments",comments);

        request.getRequestDispatcher("comments.ftl").forward(request,response);

    }


}
