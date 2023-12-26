package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class Discipline {

    private Long disciplineId;
    private String name;
    private Set<Training> trainings;

    public Discipline(Long disciplineId, String name){
        this.disciplineId = disciplineId;
        this.name = name;
    }
}
