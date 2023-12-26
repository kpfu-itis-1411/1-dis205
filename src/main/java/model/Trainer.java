package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Trainer {
    private Long trainerId;
    private String name;
    private String email;
    private String description;
    private String phoneNumber;
    private List<Training> trainings;
    public Trainer(Long trainerId, String name, String email, String description, String phoneNumber) {
        this.trainerId = trainerId;
        this.name = name;
        this.email = email;
        this.description = description;
        this.phoneNumber = phoneNumber;
    }
}
