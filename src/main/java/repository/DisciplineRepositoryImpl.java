package repository;

import model.Discipline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DisciplineRepositoryImpl implements DisciplineRepository {
    private static final String SELECT_ALL_QUERY = "SELECT * FROM discipline";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM discipline WHERE discipline_id = ?";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM discipline WHERE discipline_id = ?";
    private static final String INSERT_QUERY = "INSERT INTO discipline (discipline_id, name) VALUES (?, ?)";

    @Override
    public List<Discipline> getAll() {
        List<Discipline> disciplines = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Long id = resultSet.getLong("discipline_id");
                    String name = resultSet.getString("name");
                    disciplines.add(new Discipline(id, name));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
        return disciplines;
    }

    @Override
    public Optional<Discipline> findById(Long id) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    return Optional.of(new Discipline(id, name));
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
    public void save(Discipline discipline) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
                preparedStatement.setLong(1, discipline.getDisciplineId());
                preparedStatement.setString(2, discipline.getName());
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
