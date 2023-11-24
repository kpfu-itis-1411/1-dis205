package authorization_registration.repository;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageRepository {

    public void saveImage(Long id, String imagePath) throws SQLException, IOException {
        Connection connection = DBConnection.getConnection();
        File file = new File(imagePath);
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        for (int readNum; (readNum = fis.read(buf)) != -1;) {
            bos.write(buf, 0, readNum);
        }
        byte[] bytes = bos.toByteArray();

        String query = "INSERT INTO images (client_id, data) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, id);
            ps.setBytes(2, bytes);
            ps.executeUpdate();
        }
    }

    public byte[] getImageData(Long id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String query = "SELECT data FROM images WHERE client_id = ?";
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
