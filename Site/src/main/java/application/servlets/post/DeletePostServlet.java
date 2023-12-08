package application.servlets.post;

import application.service.PostService;
import application.service.SubscriptionsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@WebServlet("/delete_post")
public class DeletePostServlet extends HttpServlet {

    private PostService service = new PostService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Long id = Long.valueOf(request.getParameter("delete"));
        service.delete(id);
        response.sendRedirect("/Site_war/home");
    }
}