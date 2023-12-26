package repository;

import model.Trainer;

import java.util.List;
import java.util.Optional;

public interface TrainerRepository {
    public List<Trainer> getAll();
    public Optional<Trainer> findById(Long id);
    public boolean deleteById(Long id);
    public void save(Trainer trainer);

}
