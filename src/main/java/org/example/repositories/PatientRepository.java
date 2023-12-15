package org.example.repositories;

import org.example.models.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public class PatientRepository {
    private final JdbcTemplate jdbcTemplate;

    public PatientRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public final static String SQL_SAVE_PATIENT = "INSERT INTO patient (name, surname, email, dateofbirth, password) VALUES (?, ?, ?, ?, ?)";
    private final static String SQL_FIND_ALL_PATIENTS = "SELECT * FROM patient";
    public final static String SQL_FIND_PATIENT_BY_ID = "SELECT * FROM patient WHERE id = ?";
    private final static String SQL_FIND_PATIENT_BY_EMAIL_AND_PASSWORD = "SELECT * FROM patient WHERE email = ? AND password = ?";
    private final static String SQL_FIND_PATIENT_BY_EMAIL = "SELECT * FROM patient WHERE email = ?";
    private final static String SQL_FIND_PATIENT_ID_BY_EMAIL = "SELECT id FROM patient WHERE email = ?";
    private final static String SQL_UPDATE_PATIENT_BY_ID = "UPDATE patient SET name = ?, surname = ?, email = ?, dateofbirth = ?, password = ? WHERE id = ?";
    private final static String SQL_DELETE_PATIENT_BY_ID = "DELETE FROM patient WHERE id = ?";
    
    public void savePatient(Patient patient) {
        jdbcTemplate.update(SQL_SAVE_PATIENT,
                patient.getName(),
                patient.getSurname(),
                patient.getEmail(),
                patient.getDateOfBirth(),
                patient.getPassword()
        );
    }

    public List<Patient> findAllPatients() {
        return jdbcTemplate.query(SQL_FIND_ALL_PATIENTS, rowMapper);
    }

    public Optional<Patient> findPatientById(Long patientId) {
        List<Patient> patients = jdbcTemplate.query(SQL_FIND_PATIENT_BY_ID, rowMapper, patientId);
        return patients.isEmpty() ? Optional.empty() : Optional.of(patients.get(0));
    }

    private RowMapper<Patient> rowMapper = (rs, rowNum) -> mapRowToPatient(rs);

    private Patient mapRowToPatient(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        String email = resultSet.getString("email");
        Date dateOfBirth = resultSet.getDate("dateofbirth");
        String password = resultSet.getString("password");
        return new Patient(id, name, surname, email, dateOfBirth, password);
    }
    
    public Optional<Patient> findPatientByEmailAndPassword(String email, String password) {
        List<Patient> patients = jdbcTemplate.query(SQL_FIND_PATIENT_BY_EMAIL_AND_PASSWORD, rowMapper, email, password);
        return patients.isEmpty() ? Optional.empty() : Optional.of(patients.get(0));
    }
    
    public Optional<Patient> findPatientByEmail(String email) {
        List<Patient> patients = jdbcTemplate.query(SQL_FIND_PATIENT_BY_EMAIL, rowMapper, email);
        return patients.isEmpty() ? Optional.empty() : Optional.of(patients.get(0));
    }

    private RowMapper<Long>  patientIdRowMapper = (rs, rowNum) -> rs.getLong("id");
    
    public Optional<Long> findPatientIdByEmail(String email) {
        List<Long> patientIds = jdbcTemplate.query(SQL_FIND_PATIENT_ID_BY_EMAIL, patientIdRowMapper, email);
        return patientIds.isEmpty() ? Optional.empty() : Optional.of(patientIds.get(0));
    }
    
    public boolean updatePatientById(Long id, String name, String surname, String email, Date dateOfBirth, String password) {
        return jdbcTemplate.update(SQL_UPDATE_PATIENT_BY_ID, name, surname, email, dateOfBirth, password, id) > 0;
    }

    public boolean deleteById(Long patientId) {
        return jdbcTemplate.update(SQL_DELETE_PATIENT_BY_ID, patientId) > 0;
    }
}
