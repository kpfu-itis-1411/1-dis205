package ru.kpfu.itis.servlet.repository;
import ru.kpfu.itis.servlet.models.Note;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NoteRepositoryImpl implements NoteRepository {
    private static final String URL = "jdbc:postgresql://localhost:5431/Notebook";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1604";


    @Override
    public List<Note> getAllNotes() {
        List<Note> noteList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM note";
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(query)) {
                    while (resultSet.next()) {
                        noteList.add(mapResultSetToNote(resultSet,connection));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return noteList;
    }



    @Override
    public Note getNoteById(long id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM note WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return mapResultSetToNote(resultSet,connection);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveNote(Note note) {
        String query = "INSERT INTO note (title, content, createdat, user_id) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, note.getTitle());
            preparedStatement.setString(2, note.getContent());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(note.getCreatedAt()));
            preparedStatement.setLong(4, note.getOwnerId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateNote(Note note) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "UPDATE note SET title=?, content=?, createdat=? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, note.getTitle());
                preparedStatement.setString(2, note.getContent());
                preparedStatement.setTimestamp(3, Timestamp.valueOf(note.getCreatedAt()));
                preparedStatement.setLong(4, note.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteNoteById(long id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "DELETE FROM note WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public long getIdOfLastNoteByUser(long userId){
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT id FROM note WHERE user_id = ? ORDER BY createdat DESC LIMIT 1";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setLong(1, userId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getLong("id");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private Note mapResultSetToNote(ResultSet resultSet, Connection connection) throws SQLException {
        int noteId = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String content = resultSet.getString("content");
        LocalDateTime createdAt = resultSet.getTimestamp("createdat").toLocalDateTime();
        long ownerId = resultSet.getLong("user_id");
        return new Note(noteId, title, content, createdAt, ownerId);
    }

}
