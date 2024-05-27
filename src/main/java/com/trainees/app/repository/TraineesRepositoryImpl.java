package com.trainees.app.repository;

import com.trainees.app.dto.TraineeDto;
import com.trainees.app.exception.RecordNotFoundException;
import com.trainees.app.model.Trainee;
import com.trainees.app.util.TraineeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TraineesRepositoryImpl implements TraineesRepository{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TraineesRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Trainee saveTrainee(Trainee trainee) {
        int rowCount = jdbcTemplate.update("insert into trainees(trainee_name,email,location) values(?,?,?)",
                trainee.getName(), trainee.getEmail(), trainee.getLocation());
        if (rowCount > 0) {
            return getTraineeByName(trainee.getName()).get();
        }
        return null;
    }

    public Optional<Trainee> getTraineeById(Integer id) {
        try {
            Trainee trainee = jdbcTemplate.queryForObject("select * from trainees where id=" + id, new TraineeRowMapper());
            System.out.println("Optional Traineeess--->"+trainee);
            return Optional.of(trainee);
        }
        catch (DataAccessException ex){
            throw new RecordNotFoundException("Trainee with id : "+id+" Not Found");
        }
    }

    public Optional<Trainee> getTraineeByName(String name) {
        Trainee trainee =jdbcTemplate.queryForObject("select * from trainees where trainee_name='"+name+"'", new TraineeRowMapper());
        if (trainee==null){
            throw new RecordNotFoundException("Trainee with name : "+name+" Not Found");
        }
        return Optional.of(trainee);
    }

    public List<Trainee> getAllTrainees() {
        return jdbcTemplate.query("select * from trainees", new TraineeRowMapper());
    }

    public void deleteTrainee(Integer id) {
        jdbcTemplate.update("delete from trainees where id=?",id);
    }

//    public Trainee getTraineesById(Integer id) {
//        try {
//            System.out.println("HIIIIIIIIIIIII");
//            String sql = "SELECT * FROM trainees WHERE id = ?";
//            System.out.println("From Repo getByID-------->"+jdbcTemplate.queryForObject(sql, new Object[]{id}, new TraineeRowMapper()));
//            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new TraineeRowMapper());
//        } catch (DataAccessException ex) {
//            throw new RecordNotFoundException("Trainee with id: " + id + " Not Found");
//        }
//    }

    public Trainee updateTrainee(Trainee trainee){
        System.out.println("Repo Trainee-->"+trainee);
        //System.out.println(getTraineesById(1));
        int rowCount = jdbcTemplate.update("update Trainees set trainee_name=?,email=?,location=? where id=?",
                trainee.getName(),trainee.getEmail(),trainee.getLocation(),trainee.getId());
        System.out.println("Helllllllllllllloooooooooo--->"+jdbcTemplate.update("update Trainees set trainee_name=?,email=?,location=? where id=?",
                trainee.getName(),trainee.getEmail(),trainee.getLocation(),trainee.getId()));
        System.out.println(rowCount);
        if(rowCount>0){
            System.out.println("Hello from repo"+trainee.getId());
            return getTraineeById(trainee.getId()).get();
        }
        return null;
    }

    public List<Trainee> searchTraineeByName(String txt){
        System.out.println("Repo ---------> "+txt);
        return jdbcTemplate.query("select * from trainees where trainee_name Like '%"+txt+"%'",new TraineeRowMapper());

    }
}
