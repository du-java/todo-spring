package by.du.todo.service;

import by.du.todo.model.Meeting;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.function.Function;

@Component
public class MeetingFileService extends AbstractFileService<Meeting> {

    @Value("${meeting-db}")
    private String path;

    @Override
    protected Function<String, Meeting> getParse() {
        return line -> {
            final String[] strings = line.split(",");
            final Meeting meeting = new Meeting();
            meeting.setId(Integer.parseInt(strings[0]));
            meeting.setPlace(strings[1]);
            meeting.setStart(LocalDateTime.parse(strings[2]));
            meeting.setEnd(LocalDateTime.parse(strings[3]));
            meeting.setDesc(strings[4]);
            return meeting;
        };
    }

    @Override
    protected String getPath() {
        return path;
    }
}
