package authorization_registration.servlets;

import authorization_registration.model.Subscriptions;
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
import java.util.List;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private SubscriptionsService service = new SubscriptionsService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }
}


