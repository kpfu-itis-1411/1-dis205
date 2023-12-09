package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.SupportService;

import java.io.IOException;

@WebServlet("/support_list")
public class SupportListServlet extends HttpServlet {
    SupportService supportService = new SupportService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("supports", supportService.findAll());
        request.getRequestDispatcher("support_list.ftl").forward(request, response);
    }
}