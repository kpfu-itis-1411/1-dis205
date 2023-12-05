package application.servlets.post;

import application.model.Client;
import application.model.Post;
import application.service.SubscriptionsService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        HttpSession session = request.getSession(false);
        Client client = (Client) session.getAttribute("client");
        String username = client.getUserName();
        String json = gson.toJson(username);
        response.getWriter().write(json);
    }
}