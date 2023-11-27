package application.servlets;

import application.model.Client;
import application.model.Post;
import application.model.Subscriptions;
import application.service.ClientService;
import application.service.PostService;
import application.service.SubscriptionsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.List;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private SubscriptionsService subscriptionsService = new SubscriptionsService();
    private ClientService clientService = new ClientService();
    private PostService postService = new PostService();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        String name = (String)session.getAttribute("client_name");
        String username = (String)session.getAttribute("client_username");
        Long clientId = (Long)session.getAttribute("client_id");
        Client client =  clientService.findById(clientId);
//        request.setAttribute("name", name);
//        request.setAttribute("username", username);
//        request.setAttribute("status",  clientService.findById(clientId).getStatus() );
        request.setAttribute("client", client);
        List<Subscriptions> subscriptionsList = subscriptionsService.findById(clientId);
        request.setAttribute("friends", subscriptionsList.subList(0, Math.min(subscriptionsList.size(), 3)));

        List<Post> posts = postService.findAll();
        Collections.reverse(posts);
        request.setAttribute("posts", posts);

        request.getRequestDispatcher("main.ftl").forward(request, response);
    }
}
