package testpackage;

import DAO.PostDao;
import model.NewPost;

import java.util.List;

public class PostTest {
    public static void main(String[] args) {
        PostDao postDao = new PostDao();

        /*List<NewPost> mypost = postDao.findAllMyPosts("bulka");
        for (NewPost p : mypost) {
            System.out.println("Post ID: " + p.getId());
            System.out.println("User Login: " + p.getUser_login());
            System.out.println("Title: " + p.getTitle());
            System.out.println("Content: " + p.getContent());
            System.out.println("Creation Date: " + p.getDateToRelease());
            System.out.println("------------------------");
            System.out.println("------------------------");
            System.out.println("------------------------");*/
        String result = postDao.deletePostById(8,"bulka");
        System.out.println(result);
        String result1 = postDao.deletePostById(7,"bulka");
        System.out.println(result1);
        String result2 = postDao.deletePostById(10,"bulka");
        System.out.println(result2);

    }
}
