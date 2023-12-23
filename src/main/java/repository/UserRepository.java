package repository;

import models.Anime;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
	AnimeRepository animeRepository = new AnimeRepository();
	public String RegNewUser(User user) throws SQLException {
		//language=sql
		final String USER_EXISTENCE_CHECK = "select id, login, username, email, password from user_data where email = ? or login = ?";
		// language=sql
		final String NEW_USER_REGISTRATION = "insert into user_data (login, username, email, password) values (?, ?, ?, ?)";

		String login = user.getLogin();
		String username = user.getUsername();
		String email = user.getEmail();
		String password = user.getPassword();

		try {
			Connection connection = DBConnection.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(USER_EXISTENCE_CHECK);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, login);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				if (resultSet.getString("email").equals(email)) {
					return "This email address already occupied";
				} else if (resultSet.getString("login").equals(login)) {
					return "This login is already occupied";
				}
			}

			preparedStatement = connection.prepareStatement(NEW_USER_REGISTRATION);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, password);

			int updateResult = preparedStatement.executeUpdate();
			if (updateResult != 0) {
				return "New user was registered";
			}

			connection.close();
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return "Unexpected error";
	}

	public User getUserByLogin(String login) throws SQLException {
		//language=sql
		final String SEARCH_USER_BY_LOGIN = "select id, login, username, email, password from user_data where login = ?";

		User result = null;

		try {
			Connection connection = DBConnection.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USER_BY_LOGIN);
			preparedStatement.setString(1, login);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				result = new User(resultSet.getLong("id"),
						resultSet.getString("login"),
						resultSet.getString("username"),
						resultSet.getString("email"),
						resultSet.getString("password")
				);
			}

			connection.close();
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	public void update(User user) {
		//language=sql
		final String UPDATE_USER_INFO = "update user_data set username = ?, email = ?, password = ? where id = ?";

		try {
			Connection connection = DBConnection.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_INFO);

			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setLong(4, user.getId());
			preparedStatement.executeUpdate();

			connection.close();
			preparedStatement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Boolean addAnimeToUser(Long userId, Long animeId) {
		//language=sql
		final String ADD_ANIME_TO_USER = "insert into user_anime (user_id, anime_id) values (?, ?)";
		try {
			Connection connection = DBConnection.createConnection();
			PreparedStatement preparedStatement;
			boolean alreadyAdded = isAnimeAlreadyAddedToUser(userId, animeId);

			if (alreadyAdded){
				connection.close();
				return false;
			} else {
				preparedStatement = connection.prepareStatement(ADD_ANIME_TO_USER);
				preparedStatement.setLong(1, userId);
				preparedStatement.setLong(2, animeId);

				int addResult = preparedStatement.executeUpdate();
				connection.close();
				preparedStatement.close();
				return addResult > 0;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean isAnimeAlreadyAddedToUser(Long user_id, Long anime_id) {
		//language=sql
		final String USER_ANIME_CHECK = "select * from user_anime where user_id = ? and anime_id = ?";
		try {
			Connection connection = DBConnection.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(USER_ANIME_CHECK);
			preparedStatement.setLong(1, user_id);
			preparedStatement.setLong(2, anime_id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return true;
			}

			connection.close();
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return false;
	}

	public List<Anime> getUserAnimeList(String userLogin) {
		//language=sql
		final String GET_USER_ANIME_LIST = "select user_id, anime_id from user_anime where user_id = ?";
		List<Anime> userAnimeList = new ArrayList<>();

		try {
			Connection connection = DBConnection.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_ANIME_LIST);
			Long userId = getUserByLogin(userLogin).getId();
			preparedStatement.setLong(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				Long animeId = resultSet.getLong("anime_id");
				Anime anime = animeRepository.getAnimeById(animeId);
				userAnimeList.add(anime);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return userAnimeList;
	}
}
