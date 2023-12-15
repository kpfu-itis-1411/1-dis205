package org.example.repositories;

import org.example.models.Doctor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DoctorRepository {
    private final JdbcTemplate jdbcTemplate;

    public DoctorRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public final static String SQL_SAVE_DOCTOR = "INSERT INTO doctor (name, surname, email, post, password) VALUES (?, ?, ?, ?, ?)";
    private final static String SQL_FIND_ALL_DOCTORS = "SELECT * FROM doctor";
    public final static String SQL_FIND_DOCTOR_BY_ID = "SELECT * FROM doctor WHERE id = ?";
    private final static String SQL_FIND_DOCTOR_BY_EMAIL_AND_PASSWORD = "SELECT * FROM doctor WHERE email = ? AND password = ?";
    private final static String SQL_FIND_DOCTOR_BY_EMAIL = "SELECT * FROM doctor WHERE email = ?";
    private final static String SQL_UPDATE_DOCTOR_BY_ID = "UPDATE appointment SET name = ?, surname = ?, email = ?, post = ?, password = ? WHERE id = ?";
    private final static String SQL_DELETE_DOCTOR_BY_ID = "DELETE FROM doctor WHERE id = ?";

    public void saveDoctor(Doctor doctor) {
        jdbcTemplate.update(SQL_SAVE_DOCTOR,
                doctor.getName(),
                doctor.getSurname(),
                doctor.getEmail(),
                doctor.getPost(),
                doctor.getPassword()
        );
    }

    public List<Doctor> findAllDoctors() {
        return jdbcTemplate.query(SQL_FIND_ALL_DOCTORS, rowMapper);
    }

    private RowMapper<Doctor> rowMapper = (rs, rowNum) -> mapRowToDoctor(rs);

    public Optional<Doctor> findDoctorById(Long doctorId) {
        List<Doctor> doctors = jdbcTemplate.query(SQL_FIND_DOCTOR_BY_ID, rowMapper, doctorId);
        return doctors.isEmpty() ? Optional.empty() : Optional.of(doctors.get(0));
    }

    private Doctor mapRowToDoctor(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        String email = resultSet.getString("email");
        String post = resultSet.getString("post");
        String password = resultSet.getString("password");
        return new Doctor(id, name, surname, email, post, password);
    }

    public Optional<Doctor> findDoctorByEmailAndPassword(String email, String password) {
        List<Doctor> doctors = jdbcTemplate.query(SQL_FIND_DOCTOR_BY_EMAIL_AND_PASSWORD, rowMapper, email, password);
        return doctors.isEmpty() ? Optional.empty() : Optional.of(doctors.get(0));
    }

    public Optional<Doctor> findDoctorByEmail(String email) {
        List<Doctor> doctors = jdbcTemplate.query(SQL_FIND_DOCTOR_BY_EMAIL, rowMapper, email);
        return doctors.isEmpty() ? Optional.empty() : Optional.of(doctors.get(0));
    }

    public boolean updateDoctorById(Long id, String name, String surname, String email, String post, String password) {
        return jdbcTemplate.update(SQL_UPDATE_DOCTOR_BY_ID, name, surname, email, post, password, id) > 0;
    }

    public boolean deleteDoctorById(Long doctorId) {
        return jdbcTemplate.update(SQL_DELETE_DOCTOR_BY_ID, doctorId) > 0;
    }
}
