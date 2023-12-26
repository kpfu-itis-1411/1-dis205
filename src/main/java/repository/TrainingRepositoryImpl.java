package repository;

import model.Discipline;
import model.Trainer;
import model.Training;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class TrainingRepositoryImpl implements TrainingRepository {
    private static final String SELECT_ALL_QUERY = "SELECT * FROM training";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM training WHERE training_id = ?";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM training WHERE training_id = ?";
    private static final String INSERT_QUERY = "INSERT INTO training (training_id, recommended_age, title, level, date, time) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BY_DATE = "SELECT * FROM training WHERE date = ?";
    private static final String SELECT_TRAININGS_BY_TRAINER_ID = "SELECT t.training_id, t.recommended_age,t.title, t.level, t.date,t.time,t.discipline_id FROM trainer JOIN training t ON trainer.trainer_id = t.trainer_id WHERE t.trainer_id = ?";
    private static final String INSERT_CLIENT_TRAINING = "INSERT INTO client_training (client_id,training_id) values (?, ?)";
    private static final String SELECT_FROM_CLIENT_TRAINING = "SELECT COUNT(*) FROM client_training WHERE client_id = ? AND training_id = ?";
    private static final String SELECT_TRAININGS_BY_CLIENT_ID = "SELECT t.training_id,t.trainer_id,t.discipline_id,t.recommended_age,t.title,t.level,t.date,t.time FROM client_training JOIN training t ON t.training_id = client_training.training_id WHERE client_id = ?";
    private static final String DELETE_FROM_CLIENT_TRAINING = "DELETE FROM client_training where client_id = ? and training_id = ?";
    private DisciplineRepository disciplineRepository;
    private TrainerRepository trainerRepository;

    public TrainingRepositoryImpl() {
        this.disciplineRepository = new DisciplineRepositoryImpl();
        this.trainerRepository = new TrainerRepositoryImpl();
    }

    @Override
    public List<Training> getAll() {
        List<Training> trainings = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Long id = resultSet.getLong("training_id");
                    Integer recommendedAge = resultSet.getInt("recommended_age");
                    Long disciplineId = resultSet.getLong("discipline_id");
                    String title = resultSet.getString("title");
                    String level = resultSet.getString("level");
                    Date date = resultSet.getDate("date");
                    Time time = resultSet.getTime("time");
                    Optional<Discipline> optionalDiscipline = disciplineRepository.findById(disciplineId);
                    trainings.add(new Training(id, recommendedAge, title, level, date, time, optionalDiscipline.get()));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
        return trainings;
    }

    @Override
    public Optional<Training> findById(Long id) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    Integer recommendedAge = resultSet.getInt("recommended_age");
                    String title = resultSet.getString("title");
                    Long disciplineId = resultSet.getLong("discipline_id");
                    String level = resultSet.getString("level");
                    Date date = resultSet.getDate("date");
                    Time time = resultSet.getTime("time");
                    Optional<Discipline> optionalDiscipline = disciplineRepository.findById(disciplineId);
                    return Optional.of(new Training(id, recommendedAge, title, level, date, time, optionalDiscipline.get()));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID_QUERY)) {
                preparedStatement.setLong(1, id);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
    }
    @Override
    public void save(Training training) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
                preparedStatement.setLong(1, training.getTrainingId());
                preparedStatement.setInt(2, training.getRecommendedAge());
                preparedStatement.setString(3, training.getTitle());
                preparedStatement.setString(4, training.getLevel());
                preparedStatement.setDate(5, new java.sql.Date(training.getDate().getTime()));
                preparedStatement.setTime(6, training.getTime());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
    }

    @Override
    public List<Training> findByDate(Date date) {
        List<Training> trainings = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_DATE)) {
                preparedStatement.setDate(1, new java.sql.Date(date.getTime()));
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Long id = resultSet.getLong("training_id");
                        Long disciplineId = resultSet.getLong("discipline_id");
                        Long trainerId = resultSet.getLong("trainer_id");
                        Integer recommendedAge = resultSet.getInt("recommended_age");
                        String title = resultSet.getString("title");
                        String level = resultSet.getString("level");
                        Date trainingDate = resultSet.getDate("date");
                        Time time = resultSet.getTime("time");
                        Optional<Discipline> optionalDiscipline = disciplineRepository.findById(disciplineId);
                        Optional<Trainer> optionalTrainer = trainerRepository.findById(trainerId);
                        trainings.add(new Training(id, recommendedAge, title, level, trainingDate, time, optionalDiscipline.get(),optionalTrainer.get()));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
        return trainings;
    }
    @Override
    public List<Training> findByTrainerId(Long trainerId) {
        List<Training> trainings = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TRAININGS_BY_TRAINER_ID)) {
                preparedStatement.setLong(1, trainerId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Long id = resultSet.getLong("training_id");
                        Integer recommendedAge = resultSet.getInt("recommended_age");
                        String title = resultSet.getString("title");
                        String level = resultSet.getString("level");
                        Date trainingDate = resultSet.getDate("date");
                        Time time = resultSet.getTime("time");
                        Long disciplineId = resultSet.getLong("discipline_id");
                        Optional<Discipline> optionalDiscipline = disciplineRepository.findById(disciplineId);
                        trainings.add(new Training(id, recommendedAge, title, level, trainingDate, time, optionalDiscipline.get()));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
        return trainings;
    }

    @Override
    public void saveClient(Long clientId,Long trainingId) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_TRAINING)) {
                preparedStatement.setLong(1, clientId);
                preparedStatement.setLong(2, trainingId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
    }
    @Override
    public boolean findByClientTraining(Long clientId, Long trainingId) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_CLIENT_TRAINING)) {
                preparedStatement.setLong(1, clientId);
                preparedStatement.setLong(2, trainingId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count > 0;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
        return false;
    }
    @Override
    public List<Training> findByClientId(Long clientId) {
        List<Training> trainings = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TRAININGS_BY_CLIENT_ID)) {
                preparedStatement.setLong(1, clientId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Long id = resultSet.getLong("training_id");
                        Integer recommendedAge = resultSet.getInt("recommended_age");
                        String title = resultSet.getString("title");
                        String level = resultSet.getString("level");
                        Date trainingDate = resultSet.getDate("date");
                        Time time = resultSet.getTime("time");
                        Long disciplineId = resultSet.getLong("discipline_id");
                        Optional<Discipline> optionalDiscipline = disciplineRepository.findById(disciplineId);
                        trainings.add(new Training(id, recommendedAge, title, level, trainingDate, time, optionalDiscipline.get()));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
        return trainings;
    }
    @Override
    public boolean deleteFromClientTraining(Long clientId, Long trainingId) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_CLIENT_TRAINING)) {
                preparedStatement.setLong(1, clientId);
                preparedStatement.setLong(2, trainingId);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                DBConnection.getInstance().releaseConnection(connection);
            }
        }
    }
}
