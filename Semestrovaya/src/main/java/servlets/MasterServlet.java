package servlets;


import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Master;
import model.MasterListAndServices;
import service.MasterListAndServicesService;
import service.MasterService;


import java.io.IOException;
import java.util.Collections;
import java.util.List;


@WebServlet("/master")
public class MasterServlet extends HttpServlet {
    private MasterService masterService = new MasterService();


    private MasterListAndServicesService service = new MasterListAndServicesService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        doPost(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");


        Long serviceId = Long.valueOf(request.getParameter("services"));
        List<MasterListAndServices> masterlist = service.findMastersByService(serviceId);

        request.setAttribute("masters", masterlist);

        if (masterService.findByName(username)!= null) {
            request.setAttribute("zapis","");

        } else {
            request.setAttribute("zapis","Записаться");

        }

        request.getRequestDispatcher("masters.ftl").forward(request, response);
    }


}