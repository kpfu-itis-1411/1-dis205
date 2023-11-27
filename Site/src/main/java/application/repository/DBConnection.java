package application.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class DBConnection {
    private static final int MAX_CONNECTIONS = 5;
    private static Stack<Connection> connections = new Stack<>();

    public DBConnection() throws SQLException {
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            connections.push(createNewConnection());
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connections.isEmpty()) {
            return createNewConnection();
        } else {
            return connections.pop();
        }
    }

    public static void releaseConnection(Connection connection) {
        if (connection != null) {
            connections.push(connection);
        }
    }

    private static Connection createNewConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/data_base", "postgres", "root");
    }
    public static void destroyConnection() {
        try {
            if (connections.pop() != null && !connections.pop().isClosed()) {
                connections.pop().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
