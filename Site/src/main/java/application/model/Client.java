package application.model;

import application.service.AvatarService;
import application.service.ClientService;
import application.service.InformationService;
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
        ClientService.setInfo(this);
    }
}
