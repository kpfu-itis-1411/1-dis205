package authorization_registration.service;

import authorization_registration.model.Post;
import authorization_registration.repository.ImageRepository;
import authorization_registration.repository.PostRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PostService {
    private PostRepository repository;

    public PostService() {
        repository = new PostRepository();
    }


    public void save(Post post){repository.save(post);}
    public List<Post> findAll(){return repository.findAll();}
}