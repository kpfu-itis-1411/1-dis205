package security;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Client;
import model.Master;
import service.ClientService;
import service.MasterService;

import java.io.IOException;


@WebServlet("/usercheck")
public class UsercheckServlet extends HttpServlet {

    private ClientService clientService = new ClientService();
    private MasterService masterService = new MasterService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("usercheck servlet");


        String username = request.getParameter("username");
        String password = request.getParameter("password");


        Client client = clientService.findByUserName(username);

        Master master = masterService.findByName(username);


        if ( client != null && client.getPassword().equals(password)) {


            HttpSession session = request.getSession();


            session.setAttribute("clientname", client.getName());
            session.setAttribute("username", client.getUserName());
            session.setAttribute("clientid", client.getId());


            response.sendRedirect("/Semestrovaya_war/services");

        } else if (master != null && master.getPassword().equals(password)) {

            HttpSession session = request.getSession();



            session.setAttribute("username", master.getMasterlogin());
            session.setAttribute("clientid", master.getId());


            response.sendRedirect("/Semestrovaya_war/services");
        } else {

            request.setAttribute("message", "Неверный пароль или логин");
            // передаем управление сервлету-шаблонизатору для вывода страницы
            request.getRequestDispatcher("login.ftl").forward(request, response);
        }
    }
}
