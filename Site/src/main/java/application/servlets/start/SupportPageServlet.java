package application.servlets.start;

import application.model.Supports;
import application.service.SupportService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@WebServlet("/support")
public class SupportPageServlet extends HttpServlet {
    private SupportService service = new SupportService();
    private String referer;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        referer = request.getHeader("Referer");
        HttpSession session = request.getSession();
        session.setAttribute("referer", referer);
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
        request.getRequestDispatcher("support_page.ftl").forward(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String title = request.getParameter("title");
        String email = request.getParameter("email");
        String message = request.getParameter("message_support");
        Supports supports = new Supports();
        supports.setTitle(title);
        supports.setEmail(email);
        supports.setMessage(message);
        service.save(supports);

        response.sendRedirect("/Site_war/support_send");
    }
}