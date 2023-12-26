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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Supports supports = (Supports) o;

        if (!id.equals(supports.id)) return false;
        if (!title.equals(supports.title)) return false;
        if (!email.equals(supports.email)) return false;
        return message.equals(supports.message);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + message.hashCode();
        return result;
    }
}