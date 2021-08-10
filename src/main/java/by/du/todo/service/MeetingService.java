package by.du.todo.service;

import by.du.todo.model.Meeting;

import java.time.LocalDate;
import java.util.List;

public interface MeetingService extends Service<Meeting> {

    List<Meeting> getAllMeetingsByDate(final LocalDate localDate);

    List<Meeting> getAllBetween(final LocalDate from, final LocalDate to);

    List<Meeting> getAllMeetingsByPlace(final String place);
}
