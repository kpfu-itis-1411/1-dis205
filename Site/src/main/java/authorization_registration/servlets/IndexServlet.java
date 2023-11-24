package authorization_registration.servlets;

import authorization_registration.model.Subscriptions;
import authorization_registration.service.ClientService;
import authorization_registration.service.ImageService;
import authorization_registration.service.SubscriptionsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private SubscriptionsService service = new SubscriptionsService();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        String name = (String)session.getAttribute("client_name");
        String username = (String)session.getAttribute("client_username");
        Long clientId = (Long)session.getAttribute("client_id");

        request.setAttribute("name", name);
        request.setAttribute("username", username);
        request.setAttribute("status", "no status");

        List<Subscriptions> subscriptionsList = service.findById(clientId);
        request.setAttribute("friends", subscriptionsList.subList(0, Math.min(subscriptionsList.size(), 3)));
        ClientService clientService = new ClientService();
        request.setAttribute("client", clientService.findById(clientId));

        request.getRequestDispatcher("main.ftl").forward(request, response);
    }
}
