package org.example.repository;

import org.example.DBConnection;
import org.example.model.Comments;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OtzivRepository {
    public List<Comments> findAllComments(int post_id){
        List<Comments> commentList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();

            String selectQuery = "SELECT * FROM comments WHERE post_id = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1,post_id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int postId = resultSet.getInt("post_id");
                String content = resultSet.getString("text");
                String userLogin = resultSet.getString("author");

                Comments comment = new Comments();
                comment.setPostId(postId);
                comment.setText(content);
                comment.setAuthor(userLogin);
                commentList.add(comment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

        return commentList;
    }
    public String sendCommentToDb(Comments comment){
        int post_id = comment.getPostId();
        String content = comment.getText();
        String user_login = comment.getAuthor();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();

            String insertQuery = "INSERT INTO comments (post_id, text, author) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, post_id);
            preparedStatement.setString(2, content);
            preparedStatement.setString(3, user_login);
            int i = preparedStatement.executeUpdate();

            if (i != 0) {
                return "SUCCESS";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

        return "OOPS";
    }
}