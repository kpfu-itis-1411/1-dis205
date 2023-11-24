package authorization_registration.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет для отображения странички с логином и паролем для аутентификации
 */
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Атрибуты: запрос, сессия, контекст

        //Передаем управление диспетчеру , говоря, что требуется обработать сервлет по пути
        // index.ftl
        request.getRequestDispatcher("welcome_page.ftl").forward(request, response);
    }
}
