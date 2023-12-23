package models;

import lombok.Getter;

@Getter
public class User {
	private Long id;
	private String login;
	private String username;
	private String email;
	private String password;

	public User() {
	}

	public void setId(Long id){
		this.id = id;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(Long id, String login, String username, String email, String password) {
		this.id = id;
		this.login = login;
		this.username = username;
		this.email = email;
		this.password = password;
	}
}
