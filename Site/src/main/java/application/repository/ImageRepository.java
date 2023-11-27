package application.repository;


import application.model.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

import java.io.*;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@MultipartConfig
public class ImageRepository {

    public void saveAvatarUrl(Long id, String imagePath) throws SQLException, IOException {
        Connection connection = DBConnection.getConnection();
        File file = new File(imagePath);
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        for (int readNum; (readNum = fis.read(buf)) != -1;) {
            bos.write(buf, 0, readNum);
        }
        byte[] bytes = bos.toByteArray();

        String query = "INSERT INTO avatars (client_id, data) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, id);
            ps.setBytes(2, bytes);
            ps.executeUpdate();
        }
    }
    public void saveAvatarImage(Client client, byte[] imageBytes) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String query = "INSERT INTO avatars (client_id, data) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, client.getId());
            ps.setBytes(2,  imageBytes);
            ps.executeUpdate();
        }
    }

    public void updateAvatarImage(Client client, byte[] imageBytes) throws SQLException {
        Connection connection = DBConnection.getConnection();

        String query = "UPDATE avatars SET data = ? WHERE client_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setBytes(1, imageBytes);
            ps.setLong(2, client.getId());
            ps.executeUpdate();
        }
    }


    public byte[] getImageData(Client client) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String query = "SELECT data FROM avatars WHERE client_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, client.getId());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getBytes("data");
                }
            }
        }
        return null;
    }
    public byte[] getImageDataById(Long id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String query = "SELECT data FROM avatars WHERE client_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getBytes("data");
                }
            }
        }
        return null;
    }
}
