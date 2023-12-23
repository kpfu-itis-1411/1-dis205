package controller;

import DAO.PostDao;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String post_author = request.getParameter("author");
        int post_id = Integer.parseInt(request.getParameter("postId"));

        PostDao postDao = new PostDao();
        String resultDelete = postDao.deletePostById(post_id,post_author);
        if(resultDelete.equals("Пост успешно удален")){
            response.sendRedirect(request.getContextPath()+"/myPost");
        }
    }
}
