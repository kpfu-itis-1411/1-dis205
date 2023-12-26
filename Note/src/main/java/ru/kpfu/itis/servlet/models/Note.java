package ru.kpfu.itis.servlet.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    private long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private long ownerId;


}