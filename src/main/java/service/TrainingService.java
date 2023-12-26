package service;

import model.Training;
import repository.TrainingRepository;
import repository.TrainingRepositoryImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class TrainingService {
    private TrainingRepository trainingRepository;
    public TrainingService() {
        trainingRepository = new TrainingRepositoryImpl();
    }

    public List<Training> getAllTrainings() {
        return trainingRepository.getAll();
    }

    public Optional<Training> getTrainingById(Long id) {
        return trainingRepository.findById(id);
    }

    public boolean deleteTrainingById(Long id) {
        return trainingRepository.deleteById(id);
    }

    public void saveTraining(Training training) {
        trainingRepository.save(training);
    }
    public List<Training> getTrainingByDate(Date date) {
        return trainingRepository.findByDate(date);
    }
    public List<Training> getByTrainerId(Long trainerId) {
        return trainingRepository.findByTrainerId(trainerId);
    }
    public void register(Long clientId,Long trainingId) {
        trainingRepository.saveClient(clientId,trainingId);
    }
    public boolean getByClientTraining(Long clientId, Long trainingId) {
        return trainingRepository.findByClientTraining(clientId,trainingId);
    }
    public List<Training> findByClientId(Long clientId) {
        return trainingRepository.findByClientId(clientId);
    }
    public boolean deleteFromClientTraining(Long clientId, Long trainingId) {
        return trainingRepository.deleteFromClientTraining(clientId,trainingId);
    }
}
