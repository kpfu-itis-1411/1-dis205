package application.repository;

import application.model.Client;
import application.model.Post;
import application.service.ClientService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    private ClientService clientService = new ClientService();

    public List<Post> findAll() {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id, client_id, time, message, likes, dislikes from posts order by id asc"
            );

            ResultSet resultSet = statement.executeQuery();

            List<Post> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new Post(
                        resultSet.getLong("id"),
                        clientService.findById(resultSet.getLong("client_id")),
                        resultSet.getDate("time"),
                        resultSet.getTime("time"),
                        resultSet.getString("message"),
                        resultSet.getInt("likes"),
                        resultSet.getInt("dislikes")
                ));
            }
            resultSet.close();
            statement.close();
            DBConnection.destroyConnection(connection);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Post> findByClient(Client client) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id, client_id, time,likes,dislikes, message from posts where client_id = ?"
            );
            statement.setLong(1, client.getId());

            ResultSet resultSet = statement.executeQuery();

            List<Post> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new Post(
                        resultSet.getLong("id"),
                        client,
                        resultSet.getDate("time"),
                        resultSet.getTime("time"),
                        resultSet.getString("message"),
                        resultSet.getInt("likes"),
                        resultSet.getInt("dislikes")
                ));
            }
            resultSet.close();
            statement.close();
            DBConnection.destroyConnection(connection);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Post findById(Long id) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id, client_id,likes, dislikes, time, message from posts where id = ?"
            );
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            Post result = null;

            while (resultSet.next()) {
                result = new Post(
                        resultSet.getLong("id"),
                        clientService.findById(resultSet.getLong("client_id")),
                        resultSet.getDate("time"),
                        resultSet.getTime("time"),
                        resultSet.getString("message"),
                        resultSet.getInt("likes"),
                        resultSet.getInt("dislikes")
                );
            }
            resultSet.close();
            statement.close();
            DBConnection.destroyConnection(connection);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Post save(Post post) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "insert into posts (client_id,time, message,likes,dislikes) " +
                            "values ( ? , ? , ?, ?, ? ) returning id "
            );

            statement.setLong(1, post.getClient().getId());
            statement.setTimestamp(2, new java.sql.Timestamp(post.getTime().getTime()));
            statement.setString(3, post.getMessage());
            statement.setInt(4, 0);
            statement.setInt(5, 0);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                post.setId(resultSet.getLong("id"));
            }

            resultSet.close();
            statement.close();
            DBConnection.destroyConnection(connection);
            return post;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateActivity(Long id, int likes, int dislikes) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "update posts set likes = ?, dislikes = ? where id = ?"
            );

            statement.setInt(1, likes);
            statement.setInt(2, dislikes);
            statement.setLong(3, id);

            statement.executeUpdate();
            statement.close();
            DBConnection.destroyConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int countLikes(Client client) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT SUM(likes) as count FROM posts WHERE client_id = ?"
            );

            statement.setLong(1, client.getId());

            ResultSet resultSet = statement.executeQuery();

            int friendCount = 0;
            if (resultSet.next()) {
                friendCount = resultSet.getInt("count");
            }

            resultSet.close();
            statement.close();
            DBConnection.destroyConnection(connection);

            return friendCount;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Long findLastPostId() {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id from posts order by id desc limit 1"

            );
            ResultSet resultSet = statement.executeQuery();

            Long lastPostId = null;

            if (resultSet.next()) {
                lastPostId = resultSet.getLong("id");
            }

            resultSet.close();
            statement.close();
            DBConnection.destroyConnection(connection);

            return lastPostId;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Post> getAfterPostId(Long postId) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id, client_id, time, message, likes, dislikes from posts where id >= ?"
            );
            statement.setLong(1, postId);

            ResultSet resultSet = statement.executeQuery();

            List<Post> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new Post(
                        resultSet.getLong("id"),
                        clientService.findById(resultSet.getLong("client_id")),
                        resultSet.getDate("time"),
                        resultSet.getTime("time"),
                        resultSet.getString("message"),
                        resultSet.getInt("likes"),
                        resultSet.getInt("dislikes")
                ));
            }
            resultSet.close();
            statement.close();
            DBConnection.destroyConnection(connection);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
}
