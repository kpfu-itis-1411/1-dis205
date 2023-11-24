package authorization_registration.servlets;

import authorization_registration.model.Subscriptions;
import authorization_registration.service.SubscriptionsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

/**
 * Сервлет, обрабатывающий запросы, адресованные к корню сайта
 * сервлет получает из сессии (которая приходит в сервлет как часть запроса) данные клиента
 * и передает их в шаблонизатор через атрибуты запроса
 *
 * ниже приведен фрагмент файла web.xml (дескриптора развертывания веб-приложения), это альтернатива
 * аннотации @WebServlet("/"). Можно использовать что-то одно
 *
 * web.xml:
 *     <servlet>
 *         <servlet-name>Index Servlet</servlet-name>
 *         <servlet-class>ru.itis.dis205.lab10.servlets.IndexServlet</servlet-class>
 *     </servlet>
 *     <servlet-mapping>
 *         <servlet-name>Index Servlet</servlet-name>
 *         <url-pattern>/</url-pattern>
 *     </servlet-mapping>
 */
@WebServlet("/subscription")
public class SubsServlet extends HttpServlet {

    private SubscriptionsService service = new SubscriptionsService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        //Передаем управление диспетчеру , говоря, что требуется обработать сервлет по пути
        // merchlist.ftl
        request.getRequestDispatcher("main.ftl").forward(request, response);
    }
}