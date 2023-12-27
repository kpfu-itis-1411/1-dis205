package model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter@Setter
public class Client {
    private Long id;
    private String name;
    private String userName;
    private String password;
    private String phoneNumber;

    public Client() {
    }

    public Client(Long id, String name, String userName, String password, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
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
        return phoneNumber.equals(client.phoneNumber);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        return result;
    }

}
