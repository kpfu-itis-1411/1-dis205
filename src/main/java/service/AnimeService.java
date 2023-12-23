package service;

import models.Anime;
import repository.AnimeRepository;

import java.sql.SQLException;
import java.util.List;

public class AnimeService {
	private AnimeRepository animeRepository;

	public AnimeService() {
		animeRepository = new AnimeRepository();
	}

	public List<Anime> getAllAnime() throws SQLException {
		return animeRepository.getAllAnime();
	}

	public List<Anime> getAnimeByGenreName(String genreName) {
		return animeRepository.getAnimeByGenreName(genreName);
	}

	public Anime getAnimeById(Long id) {
		return animeRepository.getAnimeById(id);
	}
}
