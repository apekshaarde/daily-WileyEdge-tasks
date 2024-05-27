package com.trainees.app.repository;

import com.trainees.app.model.Trainee;

import java.util.List;
import java.util.Optional;

public interface TraineesRepository {

    public Trainee saveTrainee(Trainee trainee);

    public Optional<Trainee> getTraineeById(Integer id);

    public Optional<Trainee> getTraineeByName(String name);

    public List<Trainee> getAllTrainees();

    public void deleteTrainee(Integer id);
    public Trainee updateTrainee(Trainee trainee);

    public List<Trainee> searchTraineeByName(String txt);
}
