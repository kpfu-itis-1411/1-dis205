package org.example.repositories;

import org.example.models.Procedure;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public class ProcedureRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProcedureRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final String SQL_SAVE_PROCEDURE = "INSERT INTO procedure (name, price, doctorId) VALUES (?, ?, ?)";
    private static final String SQL_FIND_ALL_PROCEDURES = "SELECT * FROM procedure";
    private static final String SQL_FIND_PROCEDURE_BY_DOCTOR_ID = "SELECT * FROM procedure WHERE doctor_id = ?";
    private static final String SQL_FIND_PROCEDURE_BY_ID = "SELECT * FROM procedure WHERE id = ?";
    private final static String SQL_FIND_PROCEDURE_BY_NAME = "SELECT * FROM procedure WHERE name = ?";
    private final static String SQL_FIND_PROCEDURE_NAME = "SELECT name FROM procedure";
    private final static String SQL_UPDATE_PROCEDURE_BY_ID = "UPDATE procedure SET name = ?, price = ?, time = ?, doctor_id = ? WHERE id = ?";
    private final static String SQL_FIND_DOCTOR_ID_BY_NAME_OF_PROCEDURE = "SELECT doctor_id FROM procedure WHERE name = ?";
    private static final String SQL_DELETE_PROCEDURE_BY_ID = "DELETE FROM procedure WHERE id = ?";

    private RowMapper<Long>  doctorIdRowMapper = (rs, rowNum) -> rs.getLong("doctor_id");
    
    public void saveProcedure(Procedure procedure) {
        jdbcTemplate.update(SQL_SAVE_PROCEDURE,
                procedure.getName(),
                procedure.getPrice(),
                procedure.getTime(),
                procedure.getDoctorId()
        );
    }

    private RowMapper<Procedure> rowMapper = (rs, rowNum) -> mapRowToProcedure(rs);

    public List<Procedure> findAllProcedures() {
        return jdbcTemplate.query(SQL_FIND_ALL_PROCEDURES, rowMapper);
    }
    
    public Optional<Procedure> findProcedureById(Long procedureId) {
        List<Procedure> procedures = jdbcTemplate.query(SQL_FIND_PROCEDURE_BY_ID, rowMapper, procedureId);
        return procedures.isEmpty() ? Optional.empty() : Optional.of(procedures.get(0));
    }
    
    public Optional<Procedure> findProcedureByDoctorId(Long doctorId) {
        List<Procedure> procedures = jdbcTemplate.query(SQL_FIND_PROCEDURE_BY_DOCTOR_ID, rowMapper, doctorId);
        return procedures.isEmpty() ? Optional.empty() : Optional.of(procedures.get(0));
    }

    private Procedure mapRowToProcedure(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        Integer price = resultSet.getInt("price");
        String time = resultSet.getString("time");
        Long doctorId = resultSet.getLong("doctor_id");
        return new Procedure(id, name, price, time, doctorId);
    }
    
    public Optional<Procedure> findProcedureByName(String name) {
        List<Procedure> procedures = jdbcTemplate.query(SQL_FIND_PROCEDURE_BY_NAME, rowMapper, name);
        return procedures.isEmpty() ? Optional.empty() : Optional.of(procedures.get(0));
    }
    
    public Optional<Long> findDoctorIdByProcedureName(String procedureName) {
        List<Long> doctorIds = jdbcTemplate.query(SQL_FIND_DOCTOR_ID_BY_NAME_OF_PROCEDURE, doctorIdRowMapper, procedureName);
        return doctorIds.isEmpty() ? Optional.empty() : Optional.of(doctorIds.get(0));
    }

    public Optional<Procedure> findProcedures() {
        List<Procedure> procedures = jdbcTemplate.query(SQL_FIND_PROCEDURE_NAME, rowMapper);
        return procedures.isEmpty() ? Optional.empty() : Optional.of(procedures.get(0));
    }

    public boolean updateProcedureById(Long id, String name, String price, String time, Long doctorId) {
        return jdbcTemplate.update(SQL_UPDATE_PROCEDURE_BY_ID, name, price, time, doctorId, id) > 0;
    }

    public boolean deleteProcedureById(Long procedureId) {
        return jdbcTemplate.update(SQL_DELETE_PROCEDURE_BY_ID, procedureId) > 0;
    }
}
