package models;

import lombok.Getter;

@Getter
public class Genre {
	private Long id;
	private String name;

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Genre(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Genre() {
	}
}
