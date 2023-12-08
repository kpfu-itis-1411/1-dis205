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

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/profile")
@MultipartConfig
public class ProfileServlet extends HttpServlet {
    private ClientService clientService = new ClientService();
    private PostService postService = new PostService();
    private SubscriptionsService subscriptionsService = new SubscriptionsService();


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Long friend = null;
        if (request.getParameter("friendid") != null) {
            friend = Long.valueOf(request.getParameter("friendid"));
        }
        String username = null;
        if (request.getParameter("send-user-search") != null) {
            username = request.getParameter("send-user-search");
        }
        if (username != null){
            if (clientService.findByUserName(username) == null || username.equals("admin")){
                response.sendRedirect("/Site_war/home");
                return;
            }
        }
        Client client = username != null ? clientService.findByUserName(username) : clientService.findById(friend);

        HttpSession session = request.getSession(false);
        Client mainClient = (Client) session.getAttribute("client");
        List<Post> posts = postService.findByClient(client);
        request.setAttribute("posts", posts);
        request.setAttribute("client", client);
        if (!mainClient.getId().equals(client.getId())) {
            if (subscriptionsService.isFollowing(mainClient.getId(), client.getId())) {
                request.setAttribute("edit", "Followed");
            } else {
                request.setAttribute("edit", "Follow");
            }
            request.setAttribute("editlink", "/home");
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


