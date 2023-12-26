package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class Training {
    private Long trainingId;
    private Integer recommendedAge;
    private String title;
    private String level;
    private Date date;
    private Time time;
    private Trainer trainer;
    private Discipline discipline;
    private Set<Client> clients;


    public Training(Long trainingId, Integer recommendedAge, String title, String level, Date date, Time time, Discipline discipline) {
        this.trainingId = trainingId;
        this.recommendedAge = recommendedAge;
        this.title = title;
        this.level = level;
        this.date = date;
        this.time = time;
        this.discipline = discipline;
    }

    public Training(Long trainingId, Integer recommendedAge, String title, String level, Date date, Time time, Discipline discipline,Trainer trainer) {
        this.trainingId = trainingId;
        this.recommendedAge = recommendedAge;
        this.title = title;
        this.level = level;
        this.date = date;
        this.time = time;
        this.discipline = discipline;
        this.trainer = trainer;
    }

}
