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

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private ClientService service = new ClientService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // извлекаем из запроса параметры формы
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password_repeat = request.getParameter("password_repeat");
        Client client = new Client();
        client.setName(name);
        client.setPhoneNumber(phone);
        client.setPassword(password);
        client.setUserName(username);
        if (service.findByUserName(client.getUserName()) == null) {
            client = service.save(client);
            HttpSession session = request.getSession();
            session.setAttribute("client_name", client.getName());
            session.setAttribute("client_id", client.getId());
            session.setAttribute("client_username", client.getUserName());
            session.setAttribute("client", client);
            response.sendRedirect("/Site_war/index");
        } else {
            request.setAttribute("message", "Пользователь с таким username уже существует");
            request.getRequestDispatcher("reg_page.ftl").forward(request, response);
        }
    }
}
