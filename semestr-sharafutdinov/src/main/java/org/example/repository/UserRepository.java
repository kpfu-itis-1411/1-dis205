package org.example.repository;


import org.example.DBConnection;
import org.example.model.UserForRegister;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public List<UserForRegister> findAll() {
        Connection connection = null;
        try {
            connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id, email, phone_number, login, password from userchek"
            );

            ResultSet resultSet = statement.executeQuery();

            List<UserForRegister> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new UserForRegister(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                ));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }

    public UserForRegister findById(Long id) {
        Connection connection = null;
        try {
             connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id, email, phone_number, login, password from userchek where id = ? "
            );

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            UserForRegister result = null;

            if (resultSet.next()) {
                result = new UserForRegister(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }  finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }
    public boolean checkCredentials(String login, String password) {
        Connection connection = null;
        try {
             connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT id FROM userchek WHERE login = ? AND password = ?"
            );

            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            boolean result = resultSet.next();

            resultSet.close();
            statement.close();

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }
    public UserForRegister findByLogin(String login) {
        Connection connection = null;
        try {
             connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id, email, phone_number, login, password from userchek where login = ? "
            );

            statement.setString(1, login);

            ResultSet resultSet = statement.executeQuery();

            UserForRegister result = null;

            if (resultSet.next()) {
                result = new UserForRegister(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
            }

            resultSet.close();
            statement.close();

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }  finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }
    public UserForRegister findByEmail(String email) {
        Connection connection = null;
        try {
             connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id, email, phone_number, login, password from userchek where email = ? "
            );

            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            UserForRegister result = null;

            if (resultSet.next()) {
                result = new UserForRegister(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
            }

            resultSet.close();
            statement.close();

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }
    public UserForRegister findByPhoneNumber(String phone_number) {
        Connection connection = null;
        try {
             connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id, email, phone_number, login, password from userchek where phone_number = ? "
            );

            statement.setString(1, phone_number);

            ResultSet resultSet = statement.executeQuery();

            UserForRegister result = null;

            if (resultSet.next()) {
                result = new UserForRegister(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
            }

            resultSet.close();
            statement.close();

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }

    public UserForRegister save(UserForRegister user) {
        Connection connection = null;
        try {
             connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "insert into userchek (email, phone_number, login, password) " +
                            "values ( ? , ? , ? , ? ) returning id "
            );

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPhone_Number());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPassword());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
            }

            resultSet.close();
            statement.close();

            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }
}