package authorization_registration.servlets;

import authorization_registration.model.Client;
import authorization_registration.model.Post;
import authorization_registration.service.ClientService;
import authorization_registration.service.PostService;
import authorization_registration.service.SubscriptionsService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

@WebServlet("/post")
public class PostsServlet extends HttpServlet {
    private PostService service = new PostService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        StringBuilder sb = new StringBuilder();
//        BufferedReader reader = request.getReader();
//        String line;
//        while ((line = reader.readLine()) != null) {
//            sb.append(line);
//        }
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode jsonNode = mapper.readTree(sb.toString());
//        String message = jsonNode.get("message").asText();

//        HttpSession session = request.getSession(false);
//        String name = (String)session.getAttribute("client_name");
//        String username = (String)session.getAttribute("client_username");
//        Long clientId = (Long)session.getAttribute("client_id");
//
//        // создаем нового пользователя
//
//        Post post = new Post();
//        ClientService clientService = new ClientService();
//        post.setClient(clientService.findById(clientId));
//        post.setDate(new Date());
//        post.setMessage(message);
//
//        service.save(post);
    }
}

