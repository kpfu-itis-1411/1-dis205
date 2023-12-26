package application.model;

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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscriptions subscriptions = (Subscriptions) o;

        if (!id.equals(subscriptions.id)) return false;
        if (!client_id.equals(subscriptions.client_id)) return false;
        return friend_id.equals(subscriptions.friend_id);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + client_id.hashCode();
        result = 31 * result + friend_id.hashCode();
        return result;
    }
}
