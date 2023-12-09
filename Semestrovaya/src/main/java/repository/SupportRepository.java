package repository;

import model.Support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupportRepository {
    public List<Support> findAll() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id,email, message from support"
            );

            ResultSet resultSet = statement.executeQuery();

            List<Support> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new Support(
                        resultSet.getLong("id"),
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
    public void save(Support supports) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "insert into support ( email, message) values ( ? , ?) returning id "
            );

            statement.setString(1, supports.getEmail());
            statement.setString(2, supports.getMessage());
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
