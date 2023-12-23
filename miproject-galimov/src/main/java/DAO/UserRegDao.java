package DAO;
import model.UserReg;
import repository.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRegDao {
    /*
    Метод вставки в бд:
    1)Если пользователь с таким логином существуетт - return "User with the same login already exists";
    2)Если пользователь с таким емэйл существует - return "User with the same email already exists";
    3)Если вставка прошла успешно, то - return "SUCCESS";
    4)Сервлетная ошибка -  return "Oops.. Something went wrong there..!";
     */
    public String sendUserToDb(UserReg userReg) {
        String fullname = userReg.getFullName();
        String login = userReg.getLogin();
        String email = userReg.getEmail();
        String password = userReg.getPassword();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.createConnection();

            // Проверяем, существует ли пользователь с таким логином или email
            String checkExistingUserQuery = "SELECT * FROM user_data WHERE login = ? OR email = ?";
            preparedStatement = connection.prepareStatement(checkExistingUserQuery);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, email);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                if (resultSet.getString("login").equals(login)) {
                    return "User with the same login already exists";
                } else if(resultSet.getString("email").equals(email)){
                    return "User with the same email already exists";
                }
            }

            // Если пользователь с таким логином или email не существуют, выполняем вставку
            String insertQuery = "INSERT INTO user_data (login, fullname, email, password) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, fullname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            int i = preparedStatement.executeUpdate();

            // Если выполнение запроса прошло успешно и были вставлены новые записи в таблицу user_data,
            // то метод executeUpdate() возвращает количество измененных строк. Переменная i хранит это значение.
            if (i != 0) {
                return "SUCCESS";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Oops.. Something went wrong there..!";
    }
}