package application.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
public class Post {
    private Long id;
    private Client client;
    private Date date;
    private Time time;
    private String message;
    private int likes;
    private int dislikes;

    public Post() {
    }

    public Post(Long id, Client client_id, Date date, Time time, String message, int likes, int dislikes) {
        this.id = id;
        this.client = client_id;
        this.date = date;
        this.time = time;
        this.message = message;
        this.likes = likes;
        this.dislikes = dislikes;
    }
}
