package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Services {
    private Long id;
    private String name;

    public Services() {

    }
    public Services(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
