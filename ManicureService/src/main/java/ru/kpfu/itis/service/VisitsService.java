package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Visits;
import ru.kpfu.itis.repository.VisitsRepository;

public class VisitsService {

    private VisitsRepository repository;

    public VisitsService() {
        repository = new VisitsRepository();
    }

    public Visits save(Visits visits) {
        return repository.save(visits);
    }

}