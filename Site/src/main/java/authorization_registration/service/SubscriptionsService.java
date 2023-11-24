package authorization_registration.service;


import authorization_registration.model.Subscriptions;
import authorization_registration.repository.SubscriptionsRepository;

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
