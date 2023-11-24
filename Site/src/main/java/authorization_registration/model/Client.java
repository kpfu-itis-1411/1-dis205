package authorization_registration.model;

import authorization_registration.service.ImageService;
import lombok.Getter;
import lombok.Setter;

import java.sql.SQLException;
import java.util.Base64;

@Getter@Setter
public class Client {
    private Long id;
    private String name;
    private String userName;
    private String password;
    private String phoneNumber;
    private String avatar;
    public Client() {
    }

    public Client(Long id, String name, String userName, String password, String phoneNumber) throws SQLException {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        ImageService imageService = new ImageService();
        byte[] imageData;
        imageData = imageService.getImage(this.id);
        if (imageData != null) {
            avatar = Base64.getEncoder().encodeToString(imageData);
        }
        }
}
