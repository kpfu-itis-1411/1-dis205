package service;

import model.Support;
import repository.SupportRepository;

import java.util.List;

public class SupportService {
    private SupportRepository repository;

    public SupportService() {
        repository = new SupportRepository();
    }
    public List<Support> findAll() { return repository.findAll();}
    public void save(Support supports) { repository.save(supports);}
}