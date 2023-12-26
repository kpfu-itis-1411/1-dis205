package repository;

import model.Training;


import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TrainingRepository {
    public List<Training> getAll();
    public Optional<Training> findById(Long id);
    public boolean deleteById(Long id);
    public void save(Training training);
    public List<Training> findByDate(Date date);
    public List<Training> findByTrainerId(Long trainerId);
    public void saveClient(Long clientId,Long trainingId);
    public boolean findByClientTraining(Long clientId, Long trainingId);
    public List<Training> findByClientId(Long clientId);
    public boolean deleteFromClientTraining(Long clientId, Long trainingId);
}
