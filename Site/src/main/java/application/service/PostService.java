package application.service;

import application.model.Post;
import application.repository.PostRepository;

import java.util.List;

public class PostService {
    private PostRepository repository;

    public PostService() {
        repository = new PostRepository();
    }


    public Post save(Post post){return repository.save(post);}
    public List<Post> findAll(){return repository.findAll();}
}