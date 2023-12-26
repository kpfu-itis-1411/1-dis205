package repository;

import model.Trainer;
import model.Training;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrainerRepositoryImpl implements TrainerRepository {
    private static final String SELECT_ALL_QUERY = "SELECT * FROM trainer";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM trainer WHERE trainer_id = ?";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM trainer WHERE trainer_id = ?";
    private static final String INSERT_QUERY = "INSERT INTO trainer (trainer_id, name, email, description, phone_number) VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<Trainer> getAll() {
        List<Trainer> trainers = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Long id = resultSet.getLong("trainer_id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String description = resultSet.getString("description");
                    String phoneNumber = resultSet.getString("phone_number");
                    trainers.add(new Trainer(id, name, email, description, phoneNumber));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
        return trainers;
    }

    @Override
    public Optional<Trainer> findById(Long id) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String description = resultSet.getString("description");
                    String phoneNumber = resultSet.getString("phone_number");
                    return Optional.of(new Trainer(id, name, email, description, phoneNumber));
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
    public void save(Trainer trainer) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
                preparedStatement.setLong(1, trainer.getTrainerId());
                preparedStatement.setString(2, trainer.getName());
                preparedStatement.setString(3, trainer.getEmail());
                preparedStatement.setString(4, trainer.getDescription());
                preparedStatement.setString(5, trainer.getPhoneNumber());
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
}