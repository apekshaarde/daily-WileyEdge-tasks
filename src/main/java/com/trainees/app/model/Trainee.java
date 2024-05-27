package com.trainees.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trainee {

    private Integer id;
    private String name;
    private String email;
    private String location;

    public Trainee(String name, String email, String location) {
        this.name = name;
        this.email = email;
        this.location = location;
    }
}
