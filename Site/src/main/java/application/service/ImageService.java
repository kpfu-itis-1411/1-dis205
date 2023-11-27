package application.service;

import application.model.Client;
import application.repository.ImageRepository;

import java.io.IOException;
import java.sql.SQLException;

public class ImageService {
    private ImageRepository repository;

    public ImageService() {
        repository = new ImageRepository();
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