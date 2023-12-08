package application.servlets.profile;

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

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/follow")
public class FollowServlet extends HttpServlet {

    private SubscriptionsService subscriptionsService = new SubscriptionsService();
    ClientService clientService = new ClientService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        HttpSession session = request.getSession(false);
        Client friend = clientService.findByUserName(sb.toString());
        Client client = (Client) session.getAttribute("client");
        Subscriptions subscriptions = new Subscriptions();
        subscriptions.setClient_id(client);
        subscriptions.setFriend_id(friend);
        if (subscriptionsService.isFollowing(client.getId(), friend.getId())){
            subscriptionsService.unfollowClientFromFriend(subscriptions);
        } else {
            subscriptionsService.followClientOnFriend(subscriptions);
        }
    }

}