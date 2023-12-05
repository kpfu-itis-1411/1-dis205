package application.repository;

import application.model.Client;
import application.model.Information;
import application.service.AvatarService;
import application.service.InformationService;

import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class ClientRepository {


    public List<Client> findAll() {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id,name, username,password, phone_number from client"
            );

            ResultSet resultSet = statement.executeQuery();

            List<Client> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new Client(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("phone_number")
                ));
            }
            connection.close();
            resultSet.close();
            statement.close();
            DBConnection.destroyConnection(connection);

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Client findById(Long id) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id,name, username,password, phone_number from client where id = ? "
            );

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            Client result = null;

            if (resultSet.next()) {
                result = new Client(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("phone_number")
                );
            }
            connection.close();
            resultSet.close();
            statement.close();
            DBConnection.destroyConnection(connection);

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Client findByUserName(String userName) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id,name, username,password, phone_number from client where username = ? "
            );

            statement.setString(1, userName);

            ResultSet resultSet = statement.executeQuery();

            Client result = null;

            if (resultSet.next()) {
                result = new Client(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("phone_number")
                );
            }

            resultSet.close();
            statement.close();
            connection.close();
            DBConnection.destroyConnection(connection);

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Client save(Client client) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "insert into client (name,username,password,phone_number) " +
                            "values ( ? , ? , ? , ? ) returning id "
            );

            statement.setString(1, client.getName());
            statement.setString(2, client.getUserName());
            statement.setString(3, client.getPassword());
            statement.setString(4, client.getPhoneNumber());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                client.setId(resultSet.getLong("id"));
            }
            InformationService informationService = new InformationService();
            AvatarService imageService = new AvatarService();
            informationService.save(client, "no status", "not specified", "not specified");
            imageService.saveAvatarImage(client, imageService.getImageById(1L));
            resultSet.close();
            statement.close();
            connection.close();
            DBConnection.destroyConnection(connection);

            return client;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update(Client client) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "update client set name = ?, password = ?, phone_number = ? where id = ?"
            );

            statement.setString(1, client.getName());
            statement.setString(2, client.getPassword());
            statement.setString(3, client.getPhoneNumber());
            statement.setLong(4, client.getId());

            statement.executeUpdate();

            connection.close();
            statement.close();
            DBConnection.destroyConnection(connection);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setInfo(Client client) throws SQLException {
        client.setAvatar(getClientAvatar(client));
        client.setBirthday(getClientBirthday(client));
        client.setStatus(getClientStatus(client));
        client.setAbout(getClientAbout(client));
    }
    private static String getClientAvatar(Client client) throws SQLException {
        AvatarService imageService = new AvatarService();
        byte[] imageData;
        imageData = imageService.getImage(client);
        if (imageData == null) {
            imageData = imageService.getImageById(1L);
        }
        return Base64.getEncoder().encodeToString(imageData);
    }
    private static String getClientStatus(Client client) {
        InformationService service = new InformationService();
        Information information = service.findByClient(client);
        return information != null ? information.getStatus() : "";
    }
    private static String getClientBirthday(Client client) {
        InformationService service = new InformationService();
        Information information = service.findByClient(client);
        return information != null ? information.getBirthday() : "";
    }
    private static String getClientAbout(Client client) {
        InformationService service = new InformationService();
        Information information = service.findByClient(client);
        return information != null ? information.getAbout_me() : "";
    }
}