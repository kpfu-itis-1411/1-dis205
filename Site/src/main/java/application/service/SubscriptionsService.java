package application.service;


import application.model.Client;
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
    public int countFollow(Client client){return repository.countFollow(client);}
    public int countSubs(Client client){return repository.countSubs(client);}
    public void followClientOnFriend(Subscriptions subscriptions){repository.followClientOnFriend(subscriptions);}
    public boolean isFollowing(Long clientId, Long friendId) { return  repository.isFollowing(clientId, friendId);}
    public List<Subscriptions> findFollowersById(Long id) { return repository.findFollowersById(id);}
}
