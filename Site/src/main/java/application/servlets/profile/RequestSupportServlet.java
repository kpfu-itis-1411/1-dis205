package application.servlets.profile;

import application.model.Supports;
import application.service.SupportService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/support_list")
public class RequestSupportServlet extends HttpServlet {
    private SupportService service = new SupportService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("supports", service.findAll());
        request.getRequestDispatcher("support_list.ftl").forward(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("support_list.ftl.ftl").forward(request, response);
    }
}