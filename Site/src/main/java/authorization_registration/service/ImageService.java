package authorization_registration.service;

import authorization_registration.model.Image;
import authorization_registration.model.Subscriptions;
import authorization_registration.repository.ImageRepository;
import authorization_registration.repository.SubscriptionsRepository;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ImageService {
    private ImageRepository repository;

    public ImageService() {
        repository = new ImageRepository();
    }


    public byte[] getImage(Long id) throws SQLException {
        return repository.getImageData(id);
    }

    public void saveImage(Long id, String file) throws SQLException, IOException {
        repository.saveImage(id, file);
    }

}