package models;

import lombok.Getter;

@Getter
public class Anime {
	private Long id;
	private String name;
	private String type;
	private String status;
	private String genre;
	private int episodes_count;
	private String start_date;
	private String description;

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEpisodes_count(int episodes_count) {
		this.episodes_count = episodes_count;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public Anime(Long id, String name, String type, String status, String genre, int episodes_count, String start_date, String description) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.status = status;
		this.genre = genre;
		this.episodes_count = episodes_count;
		this.start_date = start_date;
		this.description = description;
	}

	public Anime(Long id, String name, String type, String status, String genre, int episodes_count, String start_date) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.status = status;
		this.genre = genre;
		this.episodes_count = episodes_count;
		this.start_date = start_date;
	}

	public Anime() {
	}
}
