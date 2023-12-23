package service;

import models.Anime;
import models.User;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService {

	private UserRepository userRepository;

	public UserService() {
		userRepository = new UserRepository();
	}

	public String RegNewUser(User user) throws SQLException {
		return userRepository.RegNewUser(user);
	}

	public User getUserByLogin(String login) throws SQLException {
		return userRepository.getUserByLogin(login);
	}

	public void update(User user) {
		userRepository.update(user);
	}

	public Boolean addAnimeToUser(Long userId, Long animeId) {
		return userRepository.addAnimeToUser(userId, animeId);
	}

	public boolean isAnimeAlreadyAddedToUser(Long user_id, Long anime_id) {
		return userRepository.isAnimeAlreadyAddedToUser(user_id, anime_id);
	}

	public List<Anime> getUserAnimeList(String userLogin) {
		return userRepository.getUserAnimeList(userLogin);
	}
}
