package application.model;

import application.service.AvatarService;
import application.service.ClientService;
import application.service.InformationService;
import lombok.Getter;
import lombok.Setter;

import java.sql.SQLException;
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
        ClientService.setInfo(this);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!id.equals(client.id)) return false;
        if (!name.equals(client.name)) return false;
        if (!userName.equals(client.userName)) return false;
        if (!password.equals(client.password)) return false;
        if (!phoneNumber.equals(client.phoneNumber)) return false;
        if (!Objects.equals(avatar, client.avatar)) return false;
        if (!Objects.equals(status, client.status)) return false;
        if (!birthday.equals(client.birthday)) return false;
        return Objects.equals(about, client.about);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 *  result + name.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + birthday.hashCode();
        result = 31 * result + (about != null ? about.hashCode() : 0);
        return result;
    }
}
