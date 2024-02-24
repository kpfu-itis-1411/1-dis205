package ru.kpfu.itis.repository.Impl;

import ru.kpfu.itis.models.Cinema;
import ru.kpfu.itis.repository.CinemaRepository;
import ru.kpfu.itis.repository.DBConnection;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CinemaRepositoryImpl implements CinemaRepository {

    //language=sql
    private final static String SQL_SELECT_ALL = "select * from cinema";

    //language=sql
    private final static String SQL_INSERT = "insert into cinema(title, director, description, year) values (?, ?, ?, ?)";

    @Override
    public void save(Cinema model) {
        Connection connection = null;
        try{
            connection = DBConnection.getInstance().getConnection();
            try(PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)){
                statement.setString(1, model.getTitle());
                statement.setString(2, model.getDirector());
                statement.setString(3, model.getDescription());
                statement.setInt(4, model.getYear());

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
    public List<Cinema> findAll() {
        List<Cinema> movies = new ArrayList<>();
        Connection connection = null;
        try{
            connection = DBConnection.getInstance().getConnection();

            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Cinema cinema = Cinema.builder()
                            .id(resultSet.getInt("id"))
                            .title(resultSet.getString("title"))
                            .description(resultSet.getString("description"))
                            .director(resultSet.getString("director"))
                            .year(resultSet.getInt("year"))
                            .build();
                    movies.add(cinema);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
        return movies;
    }
}
