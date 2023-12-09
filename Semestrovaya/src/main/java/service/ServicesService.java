package service;

import model.Services;
import repository.ServicesRepository;

import java.util.List;

public class ServicesService {
    private ServicesRepository repository;

    public ServicesService() {
        repository = new ServicesRepository();
    }
    public Services findById(Long id) {
        return repository.findById(id);
    }

    public List<Services> findAll() {
        return repository.findAll();
    }
}

