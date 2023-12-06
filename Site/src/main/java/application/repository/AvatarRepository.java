package application.repository;


import application.model.Client;


import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AvatarRepository {

    public void saveAvatarUrl(Long id, String imagePath) throws SQLException, IOException {
        Connection connection = DBConnection.getInstance().getConnection();

        File file = new File(imagePath);
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        for (int readNum; (readNum = fis.read(buf)) != -1;) {
            bos.write(buf, 0, readNum);
        }
        byte[] bytes = bos.toByteArray();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO avatars (client_id, data) VALUES (?, ?)")) {
            ps.setLong(1, id);
            ps.setBytes(2, bytes);
            ps.executeUpdate();
        }
        DBConnection.getInstance().releaseConnection(connection);
    }
    public void saveAvatarImage(Client client, byte[] imageBytes) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO avatars (client_id, data) VALUES (?, ?)")) {
            ps.setLong(1, client.getId());
            ps.setBytes(2,  imageBytes);
            ps.executeUpdate();
        }
        DBConnection.getInstance().releaseConnection(connection);
    }

    public void updateAvatarImage(Client client, byte[] imageBytes) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        try (PreparedStatement ps = connection.prepareStatement("UPDATE avatars SET data = ? WHERE client_id = ?")) {
            ps.setBytes(1, imageBytes);
            ps.setLong(2, client.getId());
            ps.executeUpdate();
        }
        DBConnection.getInstance().releaseConnection(connection);
    }


    public byte[] getImageData(Client client) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        try (PreparedStatement ps = connection.prepareStatement("SELECT data FROM avatars WHERE client_id = ?")) {
            ps.setLong(1, client.getId());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getBytes("data");
                }
            }
        }
        DBConnection.getInstance().releaseConnection(connection);
        return null;
    }
    public byte[] getImageDataById(Long id) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        try (PreparedStatement ps = connection.prepareStatement("SELECT data FROM avatars WHERE client_id = ?")) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getBytes("data");
                }
            }
        }
        DBConnection.getInstance().releaseConnection(connection);
        return null;
    }
}
