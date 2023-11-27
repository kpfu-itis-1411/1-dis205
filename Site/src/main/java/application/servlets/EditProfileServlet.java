package application.servlets;

import application.model.Client;
import application.service.ClientService;
import application.service.ImageService;
import application.service.InformationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.SQLException;

@WebServlet("/edit")
@MultipartConfig
public class EditProfileServlet extends HttpServlet {
    private ClientService clientService = new ClientService();
    private InformationService informationService = new InformationService();
    private ImageService imageService = new ImageService();
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Long id = (Long) session.getAttribute("client_id");
        String name = request.getParameter("client_name");
        String password = request.getParameter("client_password");
        String phone = request.getParameter("client_phoneNumber");
        String status = request.getParameter("client_status");
        String birthday = request.getParameter("client_birthday");
        String about = request.getParameter("client_about");
        Client client = new Client();
        client.setId(id);
        client.setName(name);
        client.setPassword(password);
        client.setPhoneNumber(phone);

        try {
            imageService.updateAvatarImage(client, uploadFile(request));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        informationService.update(client, status, birthday, about);
        clientService.update(client);
        request.getRequestDispatcher("edit_profile.ftl").forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        Long clientId = (Long)session.getAttribute("client_id");

        request.setAttribute("client", clientService.findById(clientId));
        request.getRequestDispatcher("edit_profile.ftl").forward(request, response);
    }

    private byte[] uploadFile(HttpServletRequest request) throws IOException, ServletException {
        Part filePart = request.getPart("avatar");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        if (fileName.endsWith(".jpg")) {
            try (InputStream input = filePart.getInputStream()) {
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int length;
                while ((length = input.read(buffer)) != -1) {
                    output.write(buffer, 0, length);
                }
                return output.toByteArray();
            }
        } else {
            throw new IOException();
        }
    }

}
