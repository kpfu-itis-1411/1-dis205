package repository;

import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class ClientRepositoryImpl implements ClientRepository {
    private static final String SELECT_ALL_QUERY = "SELECT * FROM client";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM client WHERE client_id = ?";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM client WHERE client_id = ?";
    private static final String INSERT_QUERY = "INSERT INTO client (name, email, phone_number, password) VALUES (?, ?, ?, ?)";
    private static final String SELECT_BY_EMAIL = "SELECT * FROM client where email = ?";

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Long id = resultSet.getLong("client_id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String phoneNumber = resultSet.getString("phone_number");
                    String password = resultSet.getString("password");
                    clients.add(new Client(id, name, email, phoneNumber, password));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
        return clients;
    }

    @Override
    public Optional<Client> findById(Long id) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String phoneNumber = resultSet.getString("phone_number");
                    String password = resultSet.getString("password");
                    return Optional.of(new Client(id, name, email, phoneNumber, password));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID_QUERY)) {
                preparedStatement.setLong(1, id);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
    }

    @Override
    public void save(Client client) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
                preparedStatement.setString(1, client.getName());
                preparedStatement.setString(2, client.getEmail());
                preparedStatement.setString(3, client.getPhoneNumber());
                preparedStatement.setString(4, client.getPassword());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
    }
    @Override
    public Optional<Client> findByEmail(String email) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_EMAIL)) {
                preparedStatement.setString(1, email);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    Long id = resultSet.getLong("client_id");
                    String name = resultSet.getString("name");
                    String phoneNumber = resultSet.getString("phone_number");
                    String password = resultSet.getString("password");
                    return Optional.of(new Client(id, name, email, phoneNumber, password, new HashSet<>()));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
        return Optional.empty();
    }
}
