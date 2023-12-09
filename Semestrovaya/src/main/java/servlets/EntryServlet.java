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
import model.Services;
import service.ClientService;
import service.EntryService;
import service.MasterService;
import service.ServicesService;

import java.io.IOException;
import java.sql.Date;


@WebServlet("/entry")
public class EntryServlet extends HttpServlet {
    ClientService clientService = new ClientService();
    MasterService masterService = new MasterService();
    ServicesService servicesService = new ServicesService();

    EntryService entryService = new EntryService();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println(request.getParameter("masterid"));

        request.getRequestDispatcher("account.ftl").forward(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        Long client_id = (Long) session.getAttribute("clientid");
        Long master_id = Long.valueOf(request.getParameter("masterid"));
        Long service_id = Long.valueOf(request.getParameter("servicesid"));
        Client client = clientService.findById(client_id);
        Master master = masterService.findById(master_id);
        Services services = servicesService.findById(service_id);

        Entry entry = new Entry();
        entry.setServices(services);
        entry.setMaster(master);
        entry.setClient(client);

        entryService.save(entry);

        request.setAttribute("client", client);
        request.setAttribute("master", master);
        request.setAttribute("services", services);
        request.getRequestDispatcher("index.ftl").forward(request, response);

    }
}