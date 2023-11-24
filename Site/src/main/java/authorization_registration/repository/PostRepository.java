package authorization_registration.repository;

import authorization_registration.model.Client;
import authorization_registration.model.Post;
import authorization_registration.service.ClientService;

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
                    "select id, client_id, date, message from client"
            );

            ResultSet resultSet = statement.executeQuery();

            List<Post> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new Post(
                        resultSet.getLong("id"),
                        clientService.findById(resultSet.getLong("client_id")),
                        resultSet.getDate("date"),
                        resultSet.getString("message")
                ));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Post save(Post post) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "insert into posts (client_id, date, message) " +
                            "values ( ? , ? , ? ) returning id "
            );

            statement.setLong(1, post.getClient().getId());
            statement.setDate(2, new java.sql.Date(post.getDate().getTime()));
            statement.setString(3, post.getMessage());


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
