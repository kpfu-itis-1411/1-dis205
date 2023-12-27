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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Support support = (Support) o;

        if (!id.equals(support.id)) return false;
        if (!email.equals(support.email)) return false;
        return message.equals(support.message);
    }
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}