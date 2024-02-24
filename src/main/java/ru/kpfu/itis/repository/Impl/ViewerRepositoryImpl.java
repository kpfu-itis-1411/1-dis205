package ru.kpfu.itis.repository.Impl;

import ru.kpfu.itis.models.Cinema;
import ru.kpfu.itis.models.Viewer;
import ru.kpfu.itis.repository.DBConnection;
import ru.kpfu.itis.repository.ViewerRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewerRepositoryImpl implements ViewerRepository {
    //language=sql
    private final static String SQL_SELECT_ALL = "select * from viewer";

    //language=sql
    private final static String SQL_INSERT = "insert into viewer(first_name, last_name, username, email, password) values (?, ?, ?, ?, ?)";
    @Override
    public void save(Viewer model) {
        Connection connection = null;
        try{
            connection = DBConnection.getInstance().getConnection();
            try(PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)){
                statement.setString(1, model.getFirstname());
                statement.setString(2, model.getLastname());
                statement.setString(3, model.getUsername());
                statement.setString(4, model.getEmail());
                statement.setString(5, model.getPassword());
                statement.executeUpdate();
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
    public List<Viewer> findAll() {
        List<Viewer> viewers = new ArrayList<>();
        Connection connection = null;
        try{
            connection = DBConnection.getInstance().getConnection();

            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Viewer viewer = Viewer.builder()
                            .id(resultSet.getInt("id"))
                            .firstname(resultSet.getString("first_name"))
                            .lastname(resultSet.getString("last_name"))
                            .username(resultSet.getString("username"))
                            .email(resultSet.getString("email"))
                            .password(resultSet.getString("password"))
                            .build();
                    viewers.add(viewer);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
        return viewers;
    }
}
