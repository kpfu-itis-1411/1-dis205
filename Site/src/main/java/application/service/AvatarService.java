package application.service;

import application.model.Client;
import application.repository.AvatarRepository;

import java.io.IOException;
import java.sql.SQLException;

public class AvatarService {
    private AvatarRepository repository;

    public AvatarService() {
        repository = new AvatarRepository();
    }


    public byte[] getImage(Client client) throws SQLException {
        return repository.getImageData(client);
    }
    public byte[] getImageById(Long id) throws SQLException {
        return repository.getImageDataById(id);
    }
    public void saveAvatarUrl(Long id, String file) throws SQLException, IOException {
        repository.saveAvatarUrl(id, file);
    }
    public void updateAvatarImage(Client client, byte[] data) throws SQLException {
        repository.updateAvatarImage(client, data);
    }
    public void saveAvatarImage(Client client, byte[] data) throws SQLException {
        repository.saveAvatarImage(client, data);
    }
}