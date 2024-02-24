package ru.kpfu.itis.servlets;



import ru.kpfu.itis.models.Viewer;
import ru.kpfu.itis.service.ViewerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/usercheck")
public class UsercheckServlet extends HttpServlet {
    private ViewerService viewerService = new ViewerService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Viewer viewer;

        viewer = viewerService.getViewer(login, password);

        if (viewer != null) {
            HttpSession session = request.getSession();
            session.setAttribute("id", viewer.getId());
            session.setAttribute("username", viewer.getUsername());
            response.sendRedirect(request.getContextPath() + "/");
        } else {
            request.setAttribute("errormessage", "Неверный логин или пароль");
            request.getRequestDispatcher("/WEB-INF/view/security/signIn.jsp").forward(request, response);
        }
    }
}