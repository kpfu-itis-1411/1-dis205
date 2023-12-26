package service;

import model.Discipline;
import repository.DisciplineRepository;
import repository.DisciplineRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class DisciplineService {
    private DisciplineRepository disciplineRepository;
    public DisciplineService() {
        disciplineRepository = new DisciplineRepositoryImpl();
    }

    public List<Discipline> getAllDisciplines() {
        return disciplineRepository.getAll();
    }

    public Optional<Discipline> getDisciplineById(Long id) {
        return disciplineRepository.findById(id);
    }

    public boolean deleteDisciplineById(Long id) {
        return disciplineRepository.deleteById(id);
    }

    public void saveDiscipline(Discipline discipline) {
        disciplineRepository.save(discipline);
    }
}
