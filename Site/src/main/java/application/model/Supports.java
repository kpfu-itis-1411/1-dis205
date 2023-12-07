package application.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Supports {
    private Long id;
    private String title;
    private String email;
    private String message;

    public Supports() {
    }

    public Supports(Long id, String title,String email, String message) {
        this.id = id;
        this.title = title;
        this.email =  email;
        this.message = message;
    }
}