package application.service;


import application.model.Subscriptions;
import application.repository.SubscriptionsRepository;

import java.util.List;

public class SubscriptionsService {
    private SubscriptionsRepository repository;

    public SubscriptionsService() {
        repository = new SubscriptionsRepository();
    }


    public List<Subscriptions> findAll() {
        return repository.findAll();
    }

    public List<Subscriptions> findById(Long id) {
        return repository.findById(id);
    }

}
