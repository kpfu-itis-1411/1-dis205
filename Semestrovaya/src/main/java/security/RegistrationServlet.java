package security;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Client;
import service.ClientService;

import java.io.IOException;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private ClientService service = new ClientService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


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
            session.setAttribute("clientname", client.getName());
            session.setAttribute("clientid", client.getId());
            session.setAttribute("username", client.getUserName());
            session.setAttribute("client", client);


            response.sendRedirect("/Semestrovaya_war/services");

        } else {
            request.setAttribute("message", "Пользователь с таким логином уже существует");
            request.getRequestDispatcher("regpage.ftl").forward(request, response);
        }
    }
}
