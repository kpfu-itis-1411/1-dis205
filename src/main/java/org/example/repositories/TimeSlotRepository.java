package org.example.repositories;

import org.example.models.TimeSlot;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TimeSlotRepository {
    private final JdbcTemplate jdbcTemplate;

    public TimeSlotRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final String SQL_SAVE_TIMESLOT = "INSERT INTO timeslot (procedurename, freetime) VALUES (?, ?)";
    private static final String SQL_FIND_ALL_TIMESLOTS_BY_PROCEDURE_NAME = "SELECT * FROM timeslot WHERE procedurename = ?";
    private static final String SQL_DELETE_TIMESLOT_BY_PROCEDURENAME_AND_FREETIME = "DELETE FROM timeslot WHERE procedurename = ? AND freetime = ?";
    
    public void saveTimeSlot(TimeSlot timeSlot) {
        jdbcTemplate.update(SQL_SAVE_TIMESLOT,
                timeSlot.getProcedureName(),
                timeSlot.getFreeTime()
        );
    }

    private RowMapper<TimeSlot> rowMapper = (rs, rowNum) -> mapRowToTimeSlot(rs);

    public List<TimeSlot> findAllTimeSlotsByProcedureName(String procedureName) {
       return  jdbcTemplate.query(SQL_FIND_ALL_TIMESLOTS_BY_PROCEDURE_NAME, rowMapper, procedureName);
    }

    private TimeSlot mapRowToTimeSlot(ResultSet resultSet) throws SQLException {
        String procedureName = resultSet.getString("procedurename");
        String freeTime = resultSet.getString("freetime");
        return new TimeSlot(procedureName, freeTime);
    }

    public boolean deleteTimeSlotByProcedureAndFreeTime(String procedureName, String freeTime) {
        return jdbcTemplate.update(SQL_DELETE_TIMESLOT_BY_PROCEDURENAME_AND_FREETIME, procedureName,freeTime) > 0;
    }
}
