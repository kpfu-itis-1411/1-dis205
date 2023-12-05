package application.model;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Avatar {
    private Long id;
    private Client client_id;
    private Byte data;

    public Avatar() {
    }

    public Avatar(Long id, Client client_id, Byte data) {
        this.id = id;
        this.client_id = client_id;
        this.data = data;
    }
}
