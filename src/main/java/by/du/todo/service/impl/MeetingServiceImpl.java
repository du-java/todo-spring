package by.du.todo.service.impl;

import by.du.todo.model.Meeting;
import by.du.todo.repository.MeetingRepository;
import by.du.todo.service.AbstractService;
import by.du.todo.service.MeetingService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Component
public class MeetingServiceImpl extends AbstractService<Meeting> implements MeetingService {

    private final MeetingRepository meetingRepository;

    public MeetingServiceImpl(final MeetingRepository meetingRepository) {
        super(meetingRepository);
        this.meetingRepository = meetingRepository;
    }

    @Override
    public List<Meeting> getAllMeetingsByDate(final LocalDate localDate) {
        if (localDate == null) {
            return Collections.emptyList();
        }
        return meetingRepository.getAllBy(x -> {
            LocalDate start = x.getStart().toLocalDate();
            LocalDate end = x.getEnd().toLocalDate();
            return start.equals(localDate) || end.equals(localDate)
                    || (start.isBefore(localDate) && end.isAfter(localDate));
        });
    }

    @Override
    public List<Meeting> getAllBetween(final LocalDate from, final LocalDate to) {
        if (from == null || to == null) {
            return Collections.emptyList();
        }
        return meetingRepository.getAllBy(x -> {
            LocalDate start = x.getStart().toLocalDate();
            LocalDate end = x.getEnd().toLocalDate();
            return start.isAfter(from) && end.isBefore(to);
        });
    }

    @Override
    public List<Meeting> getAllMeetingsByPlace(final String place) {
        if (place == null || place.isEmpty()) {
            return Collections.emptyList();
        }
        return meetingRepository.getAllBy(x -> x.getPlace().equals(place));
    }
}
