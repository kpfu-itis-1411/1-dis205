package service;

import model.Client;
import repository.ClientRepository;
import repository.ClientRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class ClientService {
    private ClientRepository clientRepository;
    public ClientService() {
        clientRepository = new ClientRepositoryImpl();
    }

    public List<Client> getAllClients() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public boolean deleteClientById(Long id) {
        return clientRepository.deleteById(id);
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }
    public Optional<Client> getClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

}
