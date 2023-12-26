package application.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Information {
    private Long id;
    private Client client_id;
    private String status;
    private String birthday;
    private String about_me;

    public Information() {
    }

    public Information(Long id, Client client_id, String status, String birthday, String about_me) {
        this.id = id;
        this.client_id = client_id;
        this.status = status;
        this.birthday = birthday;
        this.about_me = about_me;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Information information = (Information) o;

        if (!id.equals(information.id)) return false;
        if (!client_id.equals(information.client_id)) return false;
        if (!status.equals(information.status)) return false;
        if (!birthday.equals(information.birthday)) return false;
        return about_me.equals(information.about_me);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + client_id.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + birthday.hashCode();
        result = 31 * result + about_me.hashCode();
        return result;
    }
}
