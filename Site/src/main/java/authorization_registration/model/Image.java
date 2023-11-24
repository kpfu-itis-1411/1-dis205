package authorization_registration.model;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Image {
    private Long id;
    private Client client_id;
    private Byte data;

    public Image() {
    }

    public Image(Long id, Client client_id, Byte data) {
        this.id = id;
        this.client_id = client_id;
        this.data = data;
    }
}
