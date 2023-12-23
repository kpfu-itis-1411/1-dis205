package repository;

import models.Anime;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AnimeRepository {
	public List<Anime> getAllAnime() throws SQLException {
		//language=sql
		final String GET_ALL_ANIME = "select id, name, type, status, genre, episodes_count, start_date from anime_data";

		List<Anime> animeList = new ArrayList<>();

		try {
			Connection connection = DBConnection.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ANIME);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Long animeID = resultSet.getLong("id");
				String name = resultSet.getString("name");
				String type = resultSet.getString("type");
				String status = resultSet.getString("status");
				String genre = resultSet.getString("genre");
				int episodes_count = resultSet.getInt("episodes_count");
				String dateString = resultSet.getString("start_date");
				LocalDate date = LocalDate.parse(dateString);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String start_date = date.format(formatter);

				Anime animeTitle = new Anime(animeID, name, type, status, genre, episodes_count, start_date);
				animeList.add(animeTitle);
			}

			connection.close();
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return animeList;
	}


	public List<Anime> getAnimeByGenreName(String genreName) {
		//language=sql
		final String GET_ANIME_BY_GENRE_NAME = "select id, name, type, status, genre, episodes_count, start_date from anime_data where genre = ?";

		List<Anime> animeList = new ArrayList<>();

		try {
			Connection connection = DBConnection.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ANIME_BY_GENRE_NAME);
			preparedStatement.setString(1, genreName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Long animeID = resultSet.getLong("id");
				String name = resultSet.getString("name");
				String type = resultSet.getString("type");
				String status = resultSet.getString("status");
				int episodes_count = resultSet.getInt("episodes_count");
				String dateString = resultSet.getString("start_date");
				LocalDate date = LocalDate.parse(dateString);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String start_date = date.format(formatter);

				Anime animeTitle = new Anime(animeID, name, type, status, genreName, episodes_count, start_date);
				animeList.add(animeTitle);
			}

			connection.close();
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return animeList;
	}


	public Anime getAnimeById(Long id) {
		//language=sql
		final String GET_ANIME_BY_ID = "select * from anime_data where id = ?";
		Anime animeTitle = new Anime();

		try {
			Connection connection = DBConnection.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ANIME_BY_ID);
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				animeTitle.setId(resultSet.getLong("id"));
				animeTitle.setName(resultSet.getString("name"));
				animeTitle.setType(resultSet.getString("type"));
				animeTitle.setStatus(resultSet.getString("status"));
				animeTitle.setGenre(resultSet.getString("genre"));
				animeTitle.setEpisodes_count(resultSet.getInt("episodes_count"));
				animeTitle.setStart_date(resultSet.getString("start_date"));
				animeTitle.setDescription(resultSet.getString("description"));
			}

			connection.close();
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return animeTitle;
	}
}
