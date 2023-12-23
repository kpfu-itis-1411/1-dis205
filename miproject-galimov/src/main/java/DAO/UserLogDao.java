package DAO;

import model.UserLog;
import repository.DBConnection;

import java.sql.*;

public class UserLogDao {
    public String extractUserFromDb(UserLog userLog) {
        String login = userLog.getLogin();
        String password = userLog.getPassword();

        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        String passwordInDb = "";

        try {
            con = DBConnection.createConnection();
            String sql = "SELECT password FROM user_data WHERE login = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, login);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                passwordInDb = resultSet.getString("password");
                if (passwordInDb.equals(password)) {
                    return "SUCCESS";
                } else {
                    return "НЕПРАВИЛЬНЫЙ ПАРОЛЬ";
                }
            } else {
                return "ТАКОГО ПОЛЬЗОВАТЕЛЯ НЕ СУЩЕСТВУЕТ";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
