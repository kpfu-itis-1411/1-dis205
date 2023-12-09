package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Support {
    private Long id;
    private String email;
    private String message;

    public Support() {
    }

    public Support(Long id, String email, String message) {
        this.id = id;
        this.email = email;
        this.message = message;
    }
}