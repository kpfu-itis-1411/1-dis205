package application.servlets.profile;

import application.model.Client;
import application.model.Post;
import application.service.ClientService;
import application.service.PostService;
import application.service.SubscriptionsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/my_profile")
@MultipartConfig
public class ProfileServlet extends HttpServlet {
    private ClientService clientService = new ClientService();
    private PostService postService = new PostService();
    private SubscriptionsService subscriptionsService = new SubscriptionsService();


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Long friend = Long.valueOf(request.getParameter("friendid"));
        Client client = clientService.findById(friend);
        HttpSession session = request.getSession(false);
        Client mainClient = (Client) session.getAttribute("client");
        List<Post> posts = postService.findByClient(client);
        request.setAttribute("posts", posts);
        request.setAttribute("client", client);
        if (!mainClient.getId().equals(client.getId())) {
            if (subscriptionsService.isFollowing(mainClient.getId(), friend)) {
                request.setAttribute("edit", "Followed");
            } else {
                request.setAttribute("edit", "Follow");
            }
            request.setAttribute("editlink", "/index");
        } else {
            request.setAttribute("editlink", "/edit");
            request.setAttribute("edit", "Edit");
        }
        request.setAttribute("countfollow", subscriptionsService.countFollow(client));
        request.setAttribute("countSubs", subscriptionsService.countSubs(client));
        request.setAttribute("likes", postService.countLikes(client));
        request.getRequestDispatcher("profile.ftl").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Long clientId = (Long) session.getAttribute("client_id");
        Client client = clientService.findById(clientId);
        List<Post> posts = postService.findByClient(client);
        request.setAttribute("editlink", "/edit");
        request.setAttribute("edit", "Edit");
        request.setAttribute("posts", posts);
        request.setAttribute("client", client);
        request.setAttribute("countfollow", subscriptionsService.countFollow(client));
        request.setAttribute("countSubs", subscriptionsService.countSubs(client));
        request.setAttribute("likes", postService.countLikes(client));
        request.getRequestDispatcher("profile.ftl").forward(request, response);
    }
}


