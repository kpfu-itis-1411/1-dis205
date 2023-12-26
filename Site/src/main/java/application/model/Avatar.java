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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Avatar avatar = (Avatar) o;

        if (!id.equals(avatar.id)) return false;
        if (!client_id.equals(avatar.client_id)) return false;
        return data.equals(avatar.data);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + client_id.hashCode();
        result = 31 * result + data.hashCode();
        return result;
    }

}
