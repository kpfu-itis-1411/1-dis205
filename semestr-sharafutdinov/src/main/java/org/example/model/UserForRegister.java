package org.example.model;


import lombok.Getter;
import lombok.Setter;

//@Getter@Setter
public class UserForRegister {
    private Long id;
    private String email;
    private String phone_number;
    private String login;
    private String password;

    public UserForRegister() {
    }
    public UserForRegister(Long id, String email, String phone_number, String login, String password) {
        this.id = id;
        this.email = email;
        this.phone_number = phone_number;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }

    public String getPhone_Number() {
        return phone_number;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_Number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}