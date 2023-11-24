package authorization_registration.repository;

import authorization_registration.model.Client;
import authorization_registration.model.Subscriptions;
import authorization_registration.service.ClientService;

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
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
