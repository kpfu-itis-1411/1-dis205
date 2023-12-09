package repository;

import model.Master;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MasterRepository {

    public List<Master> findAll() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id, masterlogin,password, name, characterisation, workexperience, valuation,phonenumber from masterlist"
            );

            ResultSet resultSet = statement.executeQuery();

            List<Master> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new Master(
                        resultSet.getLong("id"),
                        resultSet.getString("masterlogin"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("characterisation"),
                        resultSet.getString("workexperience"),
                        resultSet.getInt("valuation"),
                        resultSet.getString("phonenumber")
                ));
            }
            DBConnection.getInstance().releaseConnection(connection);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Master findById(Long id) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id,masterlogin,password,  name, characterisation, workexperience, valuation,phonenumber from masterlist where id = ? "
            );

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            Master result = null;

            if (resultSet.next()) {
                result = new Master(
                        resultSet.getLong("id"),
                        resultSet.getString("masterlogin"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("characterisation"),
                        resultSet.getString("workexperience"),
                        resultSet.getInt("valuation"),
                        resultSet.getString("phonenumber")
                );
            }
            DBConnection.getInstance().releaseConnection(connection);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Master findByName(String name) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id,masterlogin,password, name, characterisation, workexperience, valuation,phonenumber from masterlist where masterlogin = ? "
            );

            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();

            Master result = null;

            if (resultSet.next()) {
                result = new Master(
                        resultSet.getLong("id"),
                        resultSet.getString("masterlogin"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("characterisation"),
                        resultSet.getString("workexperience"),
                        resultSet.getInt("valuation"),
                        resultSet.getString("phonenumber")
                );
            }

            resultSet.close();
            statement.close();
            DBConnection.getInstance().releaseConnection(connection);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Master save(Master master) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "insert into masterlist (masterlogin, password, name, characterisation, workexperience, valuation,phonenumber) " +
                            "values ( ?, ?, ? , ? , ? , ?, ? ) returning id "
            );
            statement.setString(1, master.getMasterlogin());
            statement.setString(2, master.getPassword());
            statement.setString(3, master.getName());
            statement.setString(4, master.getCharacterisation());
            statement.setString(5, master.getWorkexperience());
            statement.setInt(6, master.getValuation());
            statement.setString(7, master.getPhoneNumber());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                master.setId(resultSet.getLong("id"));
            }

            resultSet.close();
            statement.close();
            DBConnection.getInstance().releaseConnection(connection);
            return master;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

