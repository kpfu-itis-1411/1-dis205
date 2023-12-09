package model;

import lombok.Getter;
import lombok.Setter;


import java.sql.Time;
import java.util.Date;


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
}
