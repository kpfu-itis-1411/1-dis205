package repository;

import model.Discipline;

import java.util.List;
import java.util.Optional;

public interface DisciplineRepository {
    public List<Discipline> getAll();
    public Optional<Discipline> findById(Long id);
    public boolean deleteById(Long id);
    public void save(Discipline discipline);

}
