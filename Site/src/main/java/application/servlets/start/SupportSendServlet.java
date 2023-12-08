package application.servlets.start;

import application.service.SubscriptionsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@WebServlet("/support_send")
public class SupportSendServlet extends HttpServlet {

    private SubscriptionsService service = new SubscriptionsService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        String referer = (String) session.getAttribute("referer");
        if (referer != null) {
            try {
                URL url = new URL(referer);
                String path = url.getPath();
                String[] segments = path.split("/");
                String servletName = segments[segments.length - 1];
                request.setAttribute("link", servletName);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        request.getRequestDispatcher("support_send.ftl").forward(request, response);
    }
}