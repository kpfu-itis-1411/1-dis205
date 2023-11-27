package application.service;

import application.model.Client;
import application.model.Information;
import application.repository.InformationRepository;

import java.util.List;

public class InformationService {
    private InformationRepository repository;

    public InformationService() {
        repository = new InformationRepository();
    }


    public List<Information> findAll() {
        return repository.findAll();
    }

    public Information findByClient(Client client) {
        return repository.findByClient(client);
    }
    public void save(Client client, String status,String birthdate, String about_me) {
        repository.save(client, status, birthdate, about_me);
    }
    public void update(Client client, String status,String birthdate, String about_me) {
        repository.update(client, status, birthdate, about_me);
    }
}
