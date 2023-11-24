package authorization_registration.model;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Subscriptions {
    private Long id;
    private Client client_id;
    private Client friend_id;

    public Subscriptions() {
    }

    public Subscriptions(Long id, Client client_id, Client friend_id) {
        this.id = id;
        this.client_id = client_id;
        this.friend_id = friend_id;
    }
}
