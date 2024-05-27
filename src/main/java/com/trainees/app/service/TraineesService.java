package com.trainees.app.service;

import com.trainees.app.dto.TraineeDto;
import com.trainees.app.model.Trainee;

import java.util.List;

public interface TraineesService {
    public TraineeDto saveTrainee(TraineeDto traineeDto);

    public TraineeDto getTrainee(Integer id);

    public TraineeDto getTraineeByName(String name);

    public void deleteTrainee(Integer id);

    public List<TraineeDto> getAllTrainees();

    public TraineeDto updateTrainee(TraineeDto traineeDto);

    public List<TraineeDto> searchTraineeByName(String txt);
}

