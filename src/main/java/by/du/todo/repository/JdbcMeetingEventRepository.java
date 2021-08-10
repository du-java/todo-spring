package by.du.todo.repository;

import by.du.todo.exception.NotFoundException;
import by.du.todo.model.Meeting;
import by.du.todo.repository.mapper.MeetingRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

@Slf4j
@Primary
@Repository
@RequiredArgsConstructor
public class JdbcMeetingEventRepository implements EventRepository<Meeting> {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Meeting getById(int id) {
        log.info("getting meeting by id");
        final List<Meeting> query = jdbcTemplate.query("select * from meetings where id = ?", new MeetingRowMapper(), id);
        if (query.isEmpty()) {
            throw new NotFoundException(id);
        }
        return query.get(0);
    }

    @Override
    public void add(Meeting meeting) {
        log.info("adding meeting {}", meeting);
        final GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        final String sql = "insert into meetings (place, start_event, end_event, description) values(?,?,?,?)";
        jdbcTemplate.update(conn -> {
                    final PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, meeting.getPlace());
                    ps.setTimestamp(2, Timestamp.valueOf(meeting.getStart()));
                    ps.setTimestamp(3, Timestamp.valueOf(meeting.getEnd()));
                    ps.setString(4, meeting.getDesc());
                    return ps;
                },
                keyHolder);
        keyHolder.getKey(); // id
    }

    @Override
    public List<Meeting> getAll() {
        log.info("getting all");
        return jdbcTemplate.query("select * from meetings", new MeetingRowMapper());
    }

    @Override
    public void save(Meeting meeting) {
        log.info("updating meeting {}", meeting);
        jdbcTemplate.update("update meetings set place=?, start_event=?, end_event=?, description=? where id = ?",
                meeting.getPlace(), meeting.getStart(), meeting.getEnd(), meeting.getDesc(), meeting.getId());
    }

    @Override
    public void delete(int id) {
        log.info("deleting by id {}", id);
        jdbcTemplate.update("delete from meetings where id = ?", id);
    }
}
