package ru.kpfu.itis.servlets;

import ru.kpfu.itis.models.Viewer;
import ru.kpfu.itis.service.ViewerService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    private ViewerService viewerService = new ViewerService();
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
//        viewerService = (ViewerService) getServletContext().getAttribute("viewerService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/security/signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do post");
        String email = req.getParameter("username");
        String password = req.getParameter("password");
        if(email != null && password != null){
            System.out.println("ff");
                Viewer viewer = viewerService.getViewer(email, password);
                if(viewer == null){
                    System.out.println("ffff");
                    req.setAttribute("message", "Wrong pair username-password");
                }
                else{
                    System.out.println("ffff");
                    viewerService.auth(viewer, req, resp);
                    resp.sendRedirect(getServletContext().getContextPath() + "/");
                    return;
                }

            getServletContext().getRequestDispatcher("/WEB-INF/view/security/signIn.jsp").forward(req, resp);
        }
    }
}
