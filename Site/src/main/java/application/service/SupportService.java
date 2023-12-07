package application.service;

import application.model.Supports;
import application.repository.ClientRepository;
import application.repository.SupportRepository;

import java.util.List;

public class SupportService {
    private SupportRepository repository;

    public SupportService() {
        repository = new SupportRepository();
    }
    public List<Supports> findAll() { return repository.findAll();}
    public void save(Supports supports) { repository.save(supports);}
}
