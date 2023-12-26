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

@WebServlet("/usercheck")
public class UsercheckServlet extends HttpServlet {

    private ClientService clientService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        clientService = (ClientService) getServletContext().getAttribute("ClientService");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // извлекаем из запроса параметры формы
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // ищем в БД пользователя с указанным логином
        Optional<Client> clientOptional = clientService.getClientByEmail(email);
        if (clientOptional.isPresent()) {
            if (clientOptional.get().getPassword().equals(password)) {

                // Создаем сессию для пользователя, в атрибутах которой сохраним его идентификаторы
                HttpSession session = request.getSession();

                // будем хранить в сессии имя клиента и его id для работы с БД
                session.setAttribute("clientemail", clientOptional.get().getEmail());
                session.setAttribute("clientid", clientOptional.get().getClientId());

                // перенаправляем на главную страницу
                response.sendRedirect("/dance_school/trainings");

            } else {
                request.setAttribute("message", "Неверный пароль или логин");
                request.getRequestDispatcher("login.ftl").forward(request, response);
            }
        } else {
            // Формируем вновь страницу для ввода логина и пароля с сообщением об ошибке
            request.setAttribute("message", "Неверный пароль или логин");
            // передаем управление сервлету-шаблонизатору для вывода страницы
            // сервлет-шаблонизатор реагирует на расширение *.ftl (см. web.xml)
            request.getRequestDispatcher("login.ftl").forward(request, response);
        }

    }
}
