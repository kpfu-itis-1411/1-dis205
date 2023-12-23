package org.example;
import org.example.model.Comments;
import org.example.repository.OtzivRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OtzivRepository commentDao = new OtzivRepository();
        List<Comments> comments = commentDao.findAllComments(5);
        for (int i = 0; i < comments.size(); i++) {
            Comments comment = comments.get(i);
            System.out.println(comment.getId() + comment.getPostId() + comment.getAuthor()); // Вывод содержимого комментария
        }
    }
}