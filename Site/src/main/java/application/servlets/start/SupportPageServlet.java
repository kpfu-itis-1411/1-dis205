package application.servlets.start;

import application.model.Supports;
import application.service.SupportService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/support")
public class SupportPageServlet extends HttpServlet {
    private SupportService service = new SupportService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
        response.sendRedirect("/Site_war/support");
    }
}