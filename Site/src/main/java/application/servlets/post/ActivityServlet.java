package application.servlets.post;

import application.model.Post;
import application.service.PostService;
import application.service.SubscriptionsService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet("/activity")
public class ActivityServlet extends HttpServlet {

    private PostService service = new PostService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("main.ftl").forward(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(sb.toString());
        Long postId = jsonNode.get("id").asLong();
        int likes = jsonNode.get("likes").asInt();
        int dislikes = jsonNode.get("dislikes").asInt();
        service.updateActivity(postId,likes,dislikes);
        Post post = service.findById(postId);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        String json = gson.toJson(post);
        response.getWriter().write(json);
    }
}