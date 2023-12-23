package service;

import models.Genre;
import repository.GenreRepository;

import java.util.List;

public class GenreService {

	private GenreRepository genreRepository;

	public GenreService() {
		genreRepository = new GenreRepository();
	}

	public List<Genre> getAllGenres() {
		return genreRepository.getAllGenres();
	}
}
