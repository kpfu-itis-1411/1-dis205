package servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Services;
import service.ServicesService;


import java.io.IOException;
import java.util.List;

@WebServlet("/services")
public class ServicesServlet extends HttpServlet {
    private ServicesService service = new ServicesService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");
        if (username.equals("admin")){
            request.setAttribute("admin", "Поддержка");
        } else {
            request.setAttribute("admin", "");
        }
        List<Services> serviceslist = service.findAll();
        request.setAttribute("servicess", serviceslist);


        request.getRequestDispatcher("services.ftl").forward(request, response);
    }


}
