package DAO;

import model.ProfileData;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileDao {
    public ProfileData pullDataUsers(String login) {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ProfileData profileData;

        String idInDb = "";
        String loginInDb = "";
        String fullnameInDb = "";
        String emailInDb = "";
        String passwordInDb = "";

        try {
            con = DBConnection.createConnection();
            String sql = "SELECT id,login,fullname,email,password FROM user_data WHERE login = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, login);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                profileData = new ProfileData();
                profileData.setId(resultSet.getString("id"));
                profileData.setLogin(resultSet.getString("login"));
                profileData.setFullName(resultSet.getString("fullname"));
                profileData.setEmail(resultSet.getString("email"));
                profileData.setPassword(resultSet.getString("password"));
            }else {
                profileData = new ProfileData();
                profileData.setId("ОШИБКА");
                profileData.setLogin("ОШИБКА");
                profileData.setFullName("ОШИБКА");
                profileData.setEmail("");
                profileData.setPassword("");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return profileData;
    }
    public void updatePassword(String userLogin, String newPassword) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = DBConnection.createConnection();
            String sql = "UPDATE user_data SET password=? WHERE login=?";
            statement = con.prepareStatement(sql);
            statement.setString(1, newPassword);
            statement.setString(2, userLogin);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Закрываем ресурсы

            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
