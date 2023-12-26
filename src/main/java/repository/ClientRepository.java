package repository;

import model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    public List<Client> getAll();
    public Optional<Client> findById(Long id);
    public boolean deleteById(Long id);
    public void save(Client client);
    public Optional<Client> findByEmail(String email);
}
