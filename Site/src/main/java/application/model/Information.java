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
}
