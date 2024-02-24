package ru.kpfu.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cinema {

    private Integer id;
    private String title;
    private String description;
    private String director;
    private int year;

    public Cinema(int id, String title, String description) {
        this.id=id;
        this.title=title;
        this.description=description;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", director='" + director + '\'' +
                ", year=" + year +
                '}';
    }
}
