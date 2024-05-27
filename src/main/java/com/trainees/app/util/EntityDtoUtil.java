package com.trainees.app.util;

import com.trainees.app.dto.TraineeDto;
import com.trainees.app.model.Trainee;

public class EntityDtoUtil {

    public static Trainee convertToTraineeEntity(TraineeDto traineeDto){
        return new Trainee(traineeDto.id(),traineeDto.name(), traineeDto.email(),traineeDto.location());
    }

    public static TraineeDto convertToTraineeDto(Trainee trainee){
        return new TraineeDto(trainee.getId(),trainee.getName(),trainee.getEmail(),trainee.getLocation());
    }

}
