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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (likes != post.likes) return false;
        if (dislikes != post.dislikes) return false;
        if (!id.equals(post.id)) return false;
        if (!client.equals(post.client)) return false;
        if (!date.equals(post.date)) return false;
        if (!time.equals(post.time)) return false;
        return message.equals(post.message);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 *  result + client.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + message.hashCode();
        result = 31 * result + likes;
        result = 31 * result + dislikes;
        return result;
    }
}
