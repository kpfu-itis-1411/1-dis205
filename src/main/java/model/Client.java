package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    private Long clientId;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private Set<Training> trainings;

    public Client(Long clientId, String name, String email, String phoneNumber, String password) {
        this.clientId = clientId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

}