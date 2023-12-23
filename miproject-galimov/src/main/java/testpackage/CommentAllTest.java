package testpackage;

import DAO.CommentDao;
import model.Comment;
import model.NewPost;

import java.util.ArrayList;
import java.util.List;

public class CommentAllTest {
    public static void main(String[] args) {
        CommentDao commentDao = new CommentDao();
        List<Comment> commentList = commentDao.findAllComments(1);
        for (Comment comment : commentList) {
            System.out.println("Post ID: " + comment.getPost_id());
            System.out.println("Comment Id: " + comment.getId());
            System.out.println("Content: " + comment.getContent());
        }

    }
}
