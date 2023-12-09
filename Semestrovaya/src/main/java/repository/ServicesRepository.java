package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Services;

public class ServicesRepository {
    public List<Services> findAll() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id,name from services"
            );

            ResultSet resultSet = statement.executeQuery();

            List<Services> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new Services(
                        resultSet.getLong("id"),
                        resultSet.getString("name")
                ));
            }

            resultSet.close();
            statement.close();
            DBConnection.getInstance().releaseConnection(connection);
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Services findById(Long id) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id,name from services where id = ? "
            );

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            Services result = null;

            if (resultSet.next()) {
                result = new Services(
                        resultSet.getLong("id"),
                        resultSet.getString("name")
                );
            }
            DBConnection.getInstance().releaseConnection(connection);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

