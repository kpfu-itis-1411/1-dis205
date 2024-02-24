package ru.kpfu.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CinemaScore {
    private Integer id;
    private Integer cinema_id;
    private Integer viewer_id;
    private int score;
}
