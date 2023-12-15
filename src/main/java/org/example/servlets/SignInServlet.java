package org.example.servlets;

import org.example.service.SingInService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    private SingInService singInService;

    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        singInService = (SingInService) context.getAttribute("signInService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/sign_in.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String auth = singInService.authenticate(req);

        String destinationPage = auth.equals("error") ? "/SemestrWork1/signIn?error" : "/SemestrWork1/personalAccount";
        resp.sendRedirect(destinationPage);
    }
}