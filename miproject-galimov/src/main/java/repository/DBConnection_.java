package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class DBConnection_ {
    private static final int MAX_CONNECTIONS = 5;
    private static Stack<Connection> connectionPool = new Stack<>();

    static {
        try {
            Class.forName("org.postgresql.Driver");
            for (int i = 0; i < MAX_CONNECTIONS; i++) {
                Connection connection = createConnection();
                connectionPool.push(connection);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connectionPool.isEmpty()) {
            // Если соединения в пуле закончились, создаем новое
            Connection connection = createConnection();
            return connection;
        } else {
            // Если есть доступное соединение в пуле, берем его
            return connectionPool.pop();
        }
    }

    public static void releaseConnection(Connection connection) {
        if (connection != null) {
            try {
                // Возвращаем соединение в пул
                connectionPool.push(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static Connection createConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5433/project_db";
        String username = "postgres";
        String password = "123456";
        return DriverManager.getConnection(url, username, password);
    }
}
