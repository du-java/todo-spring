package by.du.todo.controller;

import by.du.todo.model.Meeting;
import by.du.todo.service.InputService;
import by.du.todo.service.MeetingService;
import by.du.todo.service.TranslateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Component
@RequiredArgsConstructor
public class EditMeetingController implements Controller {

    private static final String DATE_TIME_PATTERN = "yy-MM-dd H-mm";

    private final InputService inputService;
    private final MeetingService meetingService;
    private final TranslateService translateService;

    public void show() {
        final int id = inputService.nextInt(translateService.getString("inputId"));
        final Meeting meeting = meetingService.getById(id);
        final String newPlace = inputService.getLine(translateService.getString("inputPlace"));
        final String newStart = inputService.getLine(translateService.getString("inputStart"));
        final String newEnd = inputService.getLine(translateService.getString("inputDate"));
        final String newDesc = inputService.getLine(translateService.getString("inputDesc"));

        if (newPlace != null && !newPlace.isEmpty()) {
            meeting.setPlace(newPlace);
        }
        if (newDesc != null && !newDesc.isEmpty()) {
            meeting.setDesc(newDesc);
        }
        final LocalDateTime start = parseLocalDate(newStart);
        if (start != null) {
            meeting.setStart(start);
        }
        final LocalDateTime end = parseLocalDate(newEnd);
        if (end != null) {
            meeting.setEnd(end);
        }

        meetingService.save(meeting);
    }

    private LocalDateTime parseLocalDate(final String line) {
        if (line == null || line.isEmpty()) {
            return null;
        }
        try {
            return LocalDateTime.parse(line, DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
        } catch (DateTimeParseException ex) {
            return null;
        }
    }
}
