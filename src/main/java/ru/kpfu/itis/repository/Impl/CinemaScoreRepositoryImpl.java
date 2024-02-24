package ru.kpfu.itis.repository.Impl;

import ru.kpfu.itis.models.Cinema;
import ru.kpfu.itis.models.CinemaScore;
import ru.kpfu.itis.models.Viewer;
import ru.kpfu.itis.repository.CinemaScoreRepository;
import ru.kpfu.itis.repository.DBConnection;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import java.sql.*;
public class CinemaScoreRepositoryImpl implements CinemaScoreRepository {

    //language=sql
    private final static String SQL_SELECT_ALL = "select * from cinema_score";

    //language=sql
    private final static String SQL_INSERT = "insert into cinema_score(cinema_id, user_id, score) values (?, ?, ?)";


    public int getAverageScore(Integer cinema_id) {
        List<CinemaScore> scores = findAll();
        int len = scores.size();
        int result;
        int count = 0;
        int sum = 0;
        for (CinemaScore score : scores) {
            if (score.getCinema_id() == cinema_id) {
                count++;
                sum += score.getScore();
            }
        }
        result = (int) (sum / count);
        return result;
    }


    @Override
    public void save(CinemaScore model) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, model.getCinema_id());
                statement.setInt(2, model.getViewer_id());
                statement.setInt(3, model.getScore());
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
    public List<CinemaScore> findAll() {
        List<CinemaScore> scores = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();

            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    CinemaScore cinemaScore = CinemaScore.builder()
                            .id(resultSet.getInt("id"))
                            .cinema_id(resultSet.getInt("cinema_id"))
                            .viewer_id(resultSet.getInt(("viewer_id")))
                            .build();
                    scores.add(cinemaScore);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
        return scores;
    }
}