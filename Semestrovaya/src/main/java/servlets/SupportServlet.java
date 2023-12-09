package servlets;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Support;
import service.SupportService;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/support")
public class SupportServlet extends HttpServlet {
    SupportService supportService = new SupportService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        System.out.println(sb);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(sb.toString());
        String email = jsonNode.get("email").asText();
        String message = jsonNode.get("message").asText();
        Support support = new Support();
        support.setEmail(email);
        support.setMessage(message);
        supportService.save(support);
    }
}