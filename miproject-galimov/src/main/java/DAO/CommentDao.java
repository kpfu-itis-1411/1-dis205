package DAO;

import model.Comment;
import model.NewPost;
import model.UserReg;
import repository.DBConnection;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {
    public List<Comment> findAllComments(int post_id){
        List<Comment> commentList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.createConnection();

            String selectQuery = "SELECT * FROM comments WHERE post_id = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1,post_id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int postId = resultSet.getInt("post_id");
                String userLogin = resultSet.getString("user_login");
                String content = resultSet.getString("content");
                Timestamp creationTimestamp = resultSet.getTimestamp("date");

                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
                SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String creationDate = outputFormat.format(inputFormat.parse(creationTimestamp.toString()));

                Comment comment = new Comment();
                comment.setPost_id(post_id);
                comment.setUser_login(userLogin);
                comment.setContent(content);
                comment.setDate(creationDate);
                commentList.add(comment);
            }

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }

        return commentList;
    }
    public String sendCommentToDb(Comment comment){
            int post_id = comment.getPost_id();
            String user_login = comment.getUser_login();
            String content = comment.getContent();
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                connection = DBConnection.createConnection();

                String insertQuery = "INSERT INTO comments (post_id, user_login,content) VALUES (?, ?, ?)";
                preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setInt(1, post_id);
                preparedStatement.setString(2, user_login);
                preparedStatement.setString(3, content);
                int i = preparedStatement.executeUpdate();

                // Если выполнение запроса прошло успешно и были вставлены новые записи в таблицу user_data,
                // то метод executeUpdate() возвращает количество измененных строк. Переменная i хранит это значение.
                if (i != 0) {
                    return "SUCCESS";
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return "OOPS";
        }
    }

