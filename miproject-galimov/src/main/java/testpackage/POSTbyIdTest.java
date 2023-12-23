package testpackage;

import DAO.PostDao;
import model.NewPost;

public class POSTbyIdTest {
    public static void main(String[] args) {
        PostDao postDao = new PostDao();
        int postId = 1;
        NewPost newPost = postDao.findPostById(postId);
        System.out.println(newPost.getContent());
    }
}
