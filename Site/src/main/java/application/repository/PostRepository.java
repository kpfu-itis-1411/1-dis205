package application.repository;

import application.model.Post;
import application.service.ClientService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    public List<Post> findAll() {
        ClientService clientService = new ClientService();
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id, client_id, date, time, message from posts"
            );

            ResultSet resultSet = statement.executeQuery();

            List<Post> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new Post(
                        resultSet.getLong("id"),
                        clientService.findById(resultSet.getLong("client_id")),
                        resultSet.getDate("date"),
                        resultSet.getTime("time"),
                        resultSet.getString("message")
                ));
            }
            resultSet.close();
            statement.close();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Post save(Post post) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "insert into posts (client_id, date, time, message) " +
                            "values ( ? , ? , ?, ? ) returning id "
            );

            statement.setLong(1, post.getClient().getId());
            statement.setDate(2, new java.sql.Date(post.getDate().getTime()));
            statement.setTimestamp(3, new java.sql.Timestamp(post.getTime().getTime())); // Используем setTimestamp для timestamp или setDatetime для datetime
            statement.setString(4, post.getMessage());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                post.setId(resultSet.getLong("id"));
            }

            resultSet.close();
            statement.close();
            return post;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
