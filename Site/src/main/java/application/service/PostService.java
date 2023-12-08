package application.service;

import application.model.Client;
import application.model.Post;
import application.repository.PostRepository;

import java.util.List;

public class PostService {
    private PostRepository repository;
    public PostService() {
        repository = new PostRepository();
    }
    public Post save(Post post){return repository.save(post);}
    public void updateActivity(Long id, int likes, int dislikes){ repository.updateActivity(id, likes, dislikes);}
    public List<Post> findAll(){return repository.findAll();}
    public List<Post> findByClient(Client client){
        return repository.findByClient(client);
    }
    public Post findById(Long id){
        return repository.findById(id);
    }
    public int countLikes(Client client){ return repository.countLikes(client);}
    public Long findLastPostId(){ return repository.findLastPostId();}
    public List<Post> getAfterPostId(Long postId) { return repository.getAfterPostId(postId);}
    public List<Post> findMostPopularPost() { return repository.findMostPopularPost();}
    public void delete(Long id) { repository.delete(id);}
}