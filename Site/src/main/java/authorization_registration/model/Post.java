package authorization_registration.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Post {
    private Long id;
    private Client client;
    private Date date;
    private String message;

    public Post() {
    }

    public Post(Long id, Client client_id, Date date, String message) {
        this.id = id;
        this.client = client_id;
        this.date = date;
        this.message = message;
    }
}
