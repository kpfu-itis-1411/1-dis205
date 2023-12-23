package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection connection;
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/website_db";
	private static final String DB_USERNAME = "postgres";
	private static final String DB_PASSWORD = "qwerty123";

	public static Connection createConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
		return connection;
	}
}
