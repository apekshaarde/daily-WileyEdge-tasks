package com.trainees.app.dto;

public record TraineeDto(Integer id,String name,String email,String location) {

    @Override
    public String toString() {
        return "TraineeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
