package ru.kpfu.itis.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ru.kpfu.itis.model.Client;
import ru.kpfu.itis.service.ClientService;

import java.io.IOException;

/**
 * Сервлет принимает данные формы со страницы  /regpage
 * добавляет пользователя в систему
 * перенаправляет:
 *  - при успешном добавлении на страницу записи
**/

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private ClientService service = new ClientService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // извлекаем из запроса параметры формы
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        // создаем нового пользователя
        Client client = new Client();
        client.setName(name);
        client.setPhonenumber(phone);
        client.setPassword(password);

        client = service.save(client);

        // Создаем сессию для пользователя, в атрибутах которой сохраним его идентификаторы
        HttpSession session = request.getSession();

        // будем хранить в сессии имя клиента и его id для работы с БД
        session.setAttribute("clientname", client.getName());
        session.setAttribute("clientid", client.getId());

        // перенаправляем на главную страницу
        response.sendRedirect("/massage/signup");
    }
}