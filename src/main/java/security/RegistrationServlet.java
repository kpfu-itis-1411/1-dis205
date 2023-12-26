package security;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Client;
import service.ClientService;


import java.io.IOException;
import java.util.Optional;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private ClientService clientService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        clientService = (ClientService) getServletContext().getAttribute("ClientService");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //Передаем управление диспетчеру , говоря, что требуется обработать сервлет по пути
        // regpage.ftl
        request.getRequestDispatcher("regpage.ftl").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // извлекаем из запроса параметры формы
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (!validateEmail(email)) {
            HttpSession session = request.getSession();
            session.setAttribute("error", "Такая почта уже используется, или вы ввели пустую почту");
            // перенаправляем пользователя обратно на страницу регистрации
            response.sendRedirect("/dance_school/registration");
            return;
        }


        // создаем нового пользователя
        Client client = new Client();
        client.setName(name);
        client.setPhoneNumber(phone);
        client.setEmail(email);
        client.setPassword(password);

        // пытаемся добавить его в БД
        clientService.saveClient(client);

        // Создаем сессию для пользователя, в атрибутах которой сохраним его идентификаторы
        HttpSession session = request.getSession();

        // будем хранить в сессии имя клиента и его id для работы с БД
        session.setAttribute("clientemail", client.getEmail());
        session.setAttribute("clientid", client.getClientId());

        // перенаправляем на главную страницу
        response.sendRedirect("/dance_school/login");
    }

    private boolean validateEmail(String email) {
        // Проверка логина: не должен быть пустым и должен быть уникальным
        if (email == null || email.trim().isEmpty()) {
            return true;
        }

        Optional<Client> existingVisitor = clientService.getClientByEmail(email);
        return existingVisitor.isEmpty();
    }


}
