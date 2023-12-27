package model;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class MasterListAndServices {
    private Long id;
    private Master master;
    private Services services;

    public MasterListAndServices(long id, Master master, Services services) {
        this.id = id;
        this.master = master;
        this.services = services;
    }

    public MasterListAndServices() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MasterListAndServices masterListAndServices = (MasterListAndServices) o;

        if (!id.equals(masterListAndServices.id)) return false;
        if (!master.equals(masterListAndServices.master)) return false;
        return services.equals(masterListAndServices.services);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + master.hashCode();
        result = 31 * result + services.hashCode();
        return result;
    }
}
