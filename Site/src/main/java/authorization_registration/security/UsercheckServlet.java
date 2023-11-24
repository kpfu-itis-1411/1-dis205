package authorization_registration.security;

import authorization_registration.model.Client;
import authorization_registration.service.ClientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Сервлет принимает данные формы со страницы  /login
 * аутентифицирует пользователя по логину и паролю
 * перенаправляет:
 *  - при успешной аутентификации на главную страницу
 *  - при ошибке в логине или пароле вновь на страницу с шаблоном login.ftl с сообщением об ошибке
 */
@WebServlet("/usercheck")
public class UsercheckServlet extends HttpServlet {

    private ClientService service = new ClientService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("user_check servlet");

        // извлекаем из запроса параметры формы
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        // ищем в БД пользователя с указанным логином
        Client client = service.findByUserName(username);

        // если пользователь нашелся надо проверить пароль
        if ( client != null && client.getPassword().equals(password)) {

            // Создаем сессию для пользователя, в атрибутах которой сохраним его идентификаторы
            HttpSession session = request.getSession();

            // будем хранить в сессии имя клиента и его id для работы с БД
            session.setAttribute("client_name", client.getName());
            session.setAttribute("client_id", client.getId());
            session.setAttribute("client_username", client.getUserName());
            System.out.println("if");
            // перенаправляем на главную страницу
            response.sendRedirect("/Site_war/index");

        } else {
            System.out.println("else");
            // Формируем вновь страницу для ввода логина и пароля с сообщением об ошибке
            request.setAttribute("message", "Неверный пароль или логин");
            // передаем управление сервлету-шаблонизатору для вывода страницы
            // сервлет-шаблонизатор реагирует на расширение *.ftl (см. web.xml)
            request.getRequestDispatcher("login.ftl").forward(request, response);
        }
    }
}
