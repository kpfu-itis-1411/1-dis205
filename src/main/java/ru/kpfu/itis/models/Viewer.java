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
public class Viewer {
    private Integer id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
