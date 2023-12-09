package model;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class MasterListAndServices {
    private Long id;
    private Master master;
    private Services services;

    public MasterListAndServices(long id,Master master, Services services) {
        this.id = id;
        this.master = master;
        this.services = services;
    }

    public MasterListAndServices() {
    }
}
