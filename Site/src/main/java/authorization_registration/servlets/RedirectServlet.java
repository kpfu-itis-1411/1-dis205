package authorization_registration.servlets;

import authorization_registration.service.ClientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

/**
 * put for test http://localhost:8080/lab10/redirect
 */
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    private ClientService service = new ClientService();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

/*
        response.setHeader("Location","/lab10/page");
        response.sendError(302);
*/
        response.sendRedirect("/Site_war/page");
    }
}
