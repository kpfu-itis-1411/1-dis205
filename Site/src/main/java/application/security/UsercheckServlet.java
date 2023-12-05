package application.security;

import application.model.Client;
import application.service.ClientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/usercheck")
public class UsercheckServlet extends HttpServlet {

    private ClientService service = new ClientService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Client client = service.findByUserName(username);
        if ( client != null && client.getPassword().equals(password)) {

            HttpSession session = request.getSession();

            // будем хранить в сессии имя клиента и его id для работы с БД
            session.setAttribute("client_name", client.getName());
            session.setAttribute("client_id", client.getId());
            session.setAttribute("client_username", client.getUserName());

            session.setAttribute("client", client);

            response.sendRedirect("/Site_war/index");

        } else {
            request.setAttribute("message", "Неверный пароль или логин");
            request.getRequestDispatcher("login.ftl").forward(request, response);
        }
    }
}
