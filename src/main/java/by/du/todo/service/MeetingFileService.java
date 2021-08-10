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
            return Meeting.builder()
                    .id(Integer.parseInt(strings[0]))
                    .place(strings[1])
                    .start(LocalDateTime.parse(strings[2]))
                    .end(LocalDateTime.parse(strings[3]))
                    .desc(strings[4])
                    .build();
        };
    }

    @Override
    protected String getPath() {
        return path;
    }
}
