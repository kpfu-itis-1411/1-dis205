package repository;

import models.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreRepository {
	public List<Genre> getAllGenres() {
		//language=sql
		final String GET_ALL_GENRES = "select * from anime_genres";
		List<Genre> genreList = new ArrayList<>();

		try {
			Connection connection = DBConnection.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_GENRES);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Long genreID = resultSet.getLong("id");
				String genreName = resultSet.getString("genre_name");

				Genre genre = new Genre(genreID, genreName);
				genreList.add(genre);
			}

			connection.close();
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return genreList;
	}
}
