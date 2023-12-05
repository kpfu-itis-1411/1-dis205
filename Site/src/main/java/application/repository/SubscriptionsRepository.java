package application.repository;

import application.model.Client;
import application.model.Subscriptions;
import application.service.ClientService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionsRepository {
    private ClientService clientService = new ClientService();

    public List<Subscriptions> findAll() {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select client_id, friend_id from subscriptions"
            );

            ResultSet resultSet = statement.executeQuery();

            List<Subscriptions> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new Subscriptions(
                        resultSet.getLong("id"),
                        clientService.findById(resultSet.getLong("client_id")),
                        clientService.findById(resultSet.getLong("friend_id"))

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

    public List<Subscriptions> findById(Long id) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id, client_id, friend_id from subscriptions where client_id = ? "
            );

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            List<Subscriptions> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new Subscriptions(
                        resultSet.getLong("id"),
                        clientService.findById(resultSet.getLong("client_id")),
                        clientService.findById(resultSet.getLong("friend_id"))

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
    public int countFollow(Client client){
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT COUNT(friend_id) as friend_count from subscriptions where friend_id = ?"
            );

            statement.setLong(1, client.getId());

            ResultSet resultSet = statement.executeQuery();

            int friendCount = 0;
            if (resultSet.next()) {
                friendCount = resultSet.getInt("friend_count");
            }

            resultSet.close();
            statement.close();
            DBConnection.destroyConnection(connection);

            return friendCount;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int countSubs(Client client){
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT COUNT(client_id) as count from subscriptions where client_id = ?"
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
    public void followClientOnFriend(Subscriptions subscriptions) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement checkStatement = connection.prepareStatement(
                    "select * from subscriptions where client_id = ? and friend_id = ?"
            );
            checkStatement.setLong(1, subscriptions.getClient_id().getId());
            checkStatement.setLong(2, subscriptions.getFriend_id().getId());
            ResultSet checkResultSet = checkStatement.executeQuery();

            if (!checkResultSet.next() && !subscriptions.getClient_id().getId().equals(subscriptions.getFriend_id().getId())) {
                PreparedStatement insertStatement = connection.prepareStatement(
                        "insert into subscriptions (client_id, friend_id) values (?,?);"
                );
                insertStatement.setLong(1, subscriptions.getClient_id().getId());
                insertStatement.setLong(2, subscriptions.getFriend_id().getId());
                insertStatement.executeUpdate();
                insertStatement.close();
            }

            checkResultSet.close();
            checkStatement.close();
            DBConnection.destroyConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isFollowing(Long clientId, Long friendId) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select count(*) from subscriptions where client_id = ? and friend_id = ?"
            );
            statement.setLong(1, clientId);
            statement.setLong(2, friendId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
            resultSet.close();
            statement.close();
            DBConnection.destroyConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

}
