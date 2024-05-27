package com.trainees.app.service;

import com.trainees.app.dto.TraineeDto;
import com.trainees.app.model.Trainee;
import com.trainees.app.repository.TraineesRepository;
import com.trainees.app.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineesServiceImpl implements TraineesService {
    private final TraineesRepository repository;

    @Autowired
    public TraineesServiceImpl(TraineesRepository repository) {
        this.repository = repository;
    }

    public TraineeDto saveTrainee(TraineeDto traineeDto) {
        Trainee trainee = repository.saveTrainee(EntityDtoUtil.convertToTraineeEntity(traineeDto));
        return EntityDtoUtil.convertToTraineeDto(trainee);
    }

    public TraineeDto getTrainee(Integer id) {
        return repository.getTraineeById(id).map(EntityDtoUtil::convertToTraineeDto).orElse(null);
    }

    public TraineeDto getTraineeByName(String name) {
        return repository.getTraineeByName(name).map(EntityDtoUtil::convertToTraineeDto).orElse(null);
    }

    public void deleteTrainee(Integer id) {
        repository.deleteTrainee(id);
    }

    public List<TraineeDto> getAllTrainees() {
        return repository.getAllTrainees().parallelStream().map(EntityDtoUtil::convertToTraineeDto).toList();
    }


    public TraineeDto updateTrainee(TraineeDto traineeDto) {
        Trainee trainee = repository.updateTrainee(EntityDtoUtil.convertToTraineeEntity(traineeDto));
        return EntityDtoUtil.convertToTraineeDto(trainee);
    }

    public List<TraineeDto> searchTraineeByName(String txt) {
        return repository.searchTraineeByName(txt).parallelStream().map(EntityDtoUtil::convertToTraineeDto).toList();
    }
}
