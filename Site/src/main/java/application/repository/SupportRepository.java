package application.repository;

import application.model.Client;
import application.model.Supports;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupportRepository {

    public List<Supports> findAll() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id, title, email, message from supports"
            );

            ResultSet resultSet = statement.executeQuery();

            List<Supports> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new Supports(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("email"),
                        resultSet.getString("message")
                ));
            }
            resultSet.close();
            statement.close();
            DBConnection.getInstance().releaseConnection(connection);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void save(Supports supports) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "insert into supports ( title, email, message) values ( ? , ? , ? ) returning id "
            );

            statement.setString(1, supports.getTitle());
            statement.setString(2, supports.getEmail());
            statement.setString(3, supports.getMessage());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                supports.setId(resultSet.getLong("id"));
            }
            DBConnection.getInstance().releaseConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
