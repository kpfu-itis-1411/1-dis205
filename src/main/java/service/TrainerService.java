package service;

import model.Trainer;
import repository.TrainerRepository;
import repository.TrainerRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class TrainerService {
    private TrainerRepository trainerRepository;
    public TrainerService() {
        trainerRepository = new TrainerRepositoryImpl();
    }

    public List<Trainer> getAllTrainers() {
        return trainerRepository.getAll();
    }

    public Optional<Trainer> getTrainerById(Long id) {
        return trainerRepository.findById(id);
    }

    public boolean deleteTrainerById(Long id) {
        return trainerRepository.deleteById(id);
    }

    public void saveTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
    }
}
