package by.du.todo.repository.mapper;

import by.du.todo.model.Meeting;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MeetingRowMapper implements RowMapper<Meeting> {
    @Override
    public Meeting mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Meeting.builder()
                .id(rs.getInt("id"))
                .desc(rs.getString("description"))
                .place(rs.getString("place"))
                .start(rs.getTimestamp("start_event").toLocalDateTime())
                .end(rs.getTimestamp("end_event").toLocalDateTime())
                .build();
    }
}
