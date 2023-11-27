package application.repository;

import application.model.Client;
import application.model.Information;
import application.service.ClientService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InformationRepository {
    private ClientService clientService = new ClientService();

    public List<Information> findAll() {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id, client_id, status, birthdate, about_me from client_information"
            );

            ResultSet resultSet = statement.executeQuery();

            List<Information> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new Information(
                        resultSet.getLong("id"),
                        clientService.findById(resultSet.getLong("client_id")),
                        resultSet.getString("status"),
                        resultSet.getString("birthdate"),
                        resultSet.getString("about_me")

                ));
            }
            resultSet.close();
            statement.close();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Information findByClient(Client client) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id, client_id, status, birthdate, about_me from client_information where client_id = ? "
            );

            statement.setLong(1, client.getId());

            ResultSet resultSet = statement.executeQuery();

            Information result = null;

            if (resultSet.next()) {
                result = new Information(
                        resultSet.getLong("id"),
                        client,
                        resultSet.getString("status"),
                        resultSet.getString("birthdate"),
                        resultSet.getString("about_me")

                );
            }
            resultSet.close();
            statement.close();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void save(Client client, String status, String birthdate, String about_me) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "insert into client_information ( client_id, status, birthdate, about_me) " +
                            "values ( ? , ? , ? , ? ) returning id "
            );

            statement.setLong(1, client.getId());
            statement.setString(2, status);
            statement.setString(3, birthdate );
            statement.setString(4, about_me);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                client.setId(resultSet.getLong("id"));
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update(Client client, String status, String birthdate, String about_me) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "update client_information set status = ?, birthdate = ?, about_me = ? where client_id = ?"
            );

            statement.setString(1, status);
            statement.setString(2, birthdate);
            statement.setString(3, about_me);
            statement.setLong(4, client.getId());

            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
