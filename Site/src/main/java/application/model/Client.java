package application.model;

import application.service.ImageService;
import application.service.InformationService;
import lombok.Getter;
import lombok.Setter;

import java.sql.SQLException;
import java.util.Base64;
import java.util.Objects;

@Getter@Setter
public class Client {
    private Long id;
    private String name;
    private String userName;
    private String password;
    private String phoneNumber;
    private String avatar;
    private String status;
    private String birthday;
    private String about;
    public Client() {
    }

    public Client(Long id, String name, String userName, String password, String phoneNumber) throws SQLException {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.avatar = getClientAvatar();
        this.status = getClientStatus();
        this.birthday = getClientBirthday();
        this.about = getClientAbout();
    }

    private String getClientAvatar() throws SQLException {
        ImageService imageService = new ImageService();
        byte[] imageData;
        imageData = imageService.getImage(this);
        if (imageData == null) {
            imageData = imageService.getImageById(1L);
        }
        return Base64.getEncoder().encodeToString(imageData);
    }
    private String getClientStatus() {
        InformationService service = new InformationService();
        Information information = service.findByClient(this);
        return information != null ? information.getStatus() : "";
    }
    private String getClientBirthday() {
        InformationService service = new InformationService();
        Information information = service.findByClient(this);
        return information != null ? information.getBirthday() : "";
    }
    private String getClientAbout() {
        InformationService service = new InformationService();
        Information information = service.findByClient(this);
        return information != null ? information.getAbout_me() : "";
    }
}