package application.servlets;

import application.service.ClientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/my_profile")
@MultipartConfig
public class ProfileServlet extends HttpServlet {
    private ClientService clientService = new ClientService();


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("my_profile.ftl").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Long clientId = (Long)session.getAttribute("client_id");

        request.setAttribute("client", clientService.findById(clientId));

        request.getRequestDispatcher("my_profile.ftl").forward(request, response);
    }
}


