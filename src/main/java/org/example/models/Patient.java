package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Patient {
    Long id;
    String name;
    String surname;
    String email;
    Date dateOfBirth;
    String password;
}
