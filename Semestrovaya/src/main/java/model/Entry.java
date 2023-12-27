package model;

import lombok.Getter;
import lombok.Setter;




@Getter@Setter
public class Entry {

    private Long id;
    private Services services;
    private Master master;

    private Client client;



    public Entry (Long id, Services services, Master master, Client client) {
        this.id = id;
        this.services = services;
        this.master = master;
        this.client = client;


    }

    public Entry() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entry entry = (Entry) o;

        if (!id.equals(entry.id)) return false;
        if (!services.equals(entry.services)) return false;
        if (!master.equals(entry.master)) return false;
        return client.equals(entry.client);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + services.hashCode();
        result = 31 * result + master.hashCode();
        result = 31 * result + client.hashCode();
        return result;
    }
}
