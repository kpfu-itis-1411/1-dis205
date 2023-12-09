package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Client;
import model.Entry;
import model.Master;
import service.ClientService;
import service.EntryService;
import service.MasterService;

import java.io.IOException;
import java.sql.Date;
import java.util.List;


@WebServlet("/account")
public class AccountServlet extends HttpServlet {

    EntryService entryService = new EntryService();
    ClientService clientService = new ClientService();
    private MasterService masterService = new MasterService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);

        String username = (String) session.getAttribute("username");

        Client client = clientService.findByUserName(username);
        Master master = masterService.findByName(username);
        List<Entry> entryList;
        if (client!= null) {
            entryList = entryService.findById(client.getId());
        } else {
            entryList = entryService.findByIdMaster(master.getId());
        }
        request.setAttribute("listEntry",entryList);

        request.getRequestDispatcher("account.ftl").forward(request, response);
    }
}