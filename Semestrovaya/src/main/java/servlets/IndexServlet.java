package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

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
@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        request.getRequestDispatcher("index.ftl").forward(request, response);
    }
}
