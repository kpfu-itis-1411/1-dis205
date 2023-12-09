package service;

import model.Master;

import repository.MasterRepository;

import java.util.List;

public class MasterService {

    private MasterRepository repository;

    public MasterService() {
        repository = new MasterRepository();
    }

    public Master save(Master master) {
        return repository.save(master);
    }

    public List<Master> findAll() {
        return repository.findAll();
    }

    public Master findById(Long id) {
        return repository.findById(id);
    }

    public Master findByName(String name) {
        return repository.findByName(name);
    }
}
