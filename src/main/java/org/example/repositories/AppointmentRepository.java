package org.example.repositories;

import org.example.models.Appointment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppointmentRepository {
    private final JdbcTemplate jdbcTemplate;

    public AppointmentRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public final static String SQL_SAVE_APPOINTMENT = "INSERT INTO appointment (name, appointmentdate, doctor_id, patient_id) VALUES (?, ?, ?, ?)";
    private final static String SQL_FIND_ALL_APPOINTMENT = "SELECT * FROM appointment";
    public final static String SQL_FIND_APPOINTMENT_BY_ID = "SELECT * FROM appointment WHERE id = ?";
    private final static String SQL_FIND_APPOINTMENT_BY_PATIENT_ID = "SELECT * FROM appointment WHERE patient_id = ?";
    private final static String SQL_FIND_APPOINTMENT_BY_DOCTOR_ID = "SELECT * FROM appointment WHERE doctor_id = ?";
    private final static String SQL_UPDATE_APPOINTMENT_BY_ID = "UPDATE appointment SET name = ?, appointmentdate = ?, doctor_id = ?, patient_id = ?  WHERE id = ?";
    private final static String SQL_DELETE_APPOINTMENT_BY_ID = "DELETE FROM appointment WHERE id = ?";
    public void saveAppointment(Appointment appointment) {
        jdbcTemplate.update(SQL_SAVE_APPOINTMENT,
                appointment.getName(),
                appointment.getAppointmentDate(),
                appointment.getDoctorId(),
                appointment.getPatientId()
        );
    }
    public List<Appointment> findAllAppointments() {
        return jdbcTemplate.query(SQL_FIND_ALL_APPOINTMENT, rowMapper);
    }
    public Optional<Appointment> findAppointmentById(Long appointmentId) {
        List<Appointment> appointments = jdbcTemplate.query(SQL_FIND_APPOINTMENT_BY_ID, rowMapper, appointmentId);
        return appointments.isEmpty() ? Optional.empty() : Optional.of(appointments.get(0));
    }

    //создаем объект RowMapper, который преобразовывает строки из результата запроса базы данных
    // в объект Appointment.
    // Он использует лямбда-выражение для определения функции mapRowToAppointment,
    // которая принимает ResultSet и номер строки и возвращает объект Appointment.
    // Эта функция вызывается для каждой строки результата запроса базы данных,
    // чтобы создать соответствующий объект Appointment.
    private RowMapper<Appointment> rowMapper = (rs, rowNum) -> mapRowToAppointment(rs);
    private Appointment mapRowToAppointment(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String appointmentDate = resultSet.getString("appointmentdate");
        Long doctorId = resultSet.getLong("doctor_id");
        Long patientId = resultSet.getLong("patient_id");
        return new Appointment(id, name, appointmentDate, doctorId, patientId);
    }

    public List<Appointment> findAppointmentsByPatientId(Long patientId) {
        return jdbcTemplate.query(SQL_FIND_APPOINTMENT_BY_PATIENT_ID, rowMapper, patientId);
    }
    public List<Appointment> findAppointmentsByDoctorId(Long doctorId) {
        return jdbcTemplate.query(SQL_FIND_APPOINTMENT_BY_DOCTOR_ID, rowMapper, doctorId);
    }

    public boolean updateAppointmentById(Long id, String name, String appointmentDate, Long doctorId, Long patientId) {
        return jdbcTemplate.update(SQL_UPDATE_APPOINTMENT_BY_ID, name, appointmentDate, doctorId, patientId, id) > 0;
    }

    public boolean deleteAppointmentById(Long appointmentId) {
        return jdbcTemplate.update(SQL_DELETE_APPOINTMENT_BY_ID, appointmentId) > 0;
    }
}

