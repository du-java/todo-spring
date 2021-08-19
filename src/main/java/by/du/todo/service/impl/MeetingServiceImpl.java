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
        return meetingRepository.findAllByStart(localDate);
    }

    @Override
    public List<Meeting> getAllBetween(final LocalDate from, final LocalDate to) {
        return null;
    }

    @Override
    public List<Meeting> getAllMeetingsByPlace(final String place) {
        return Collections.emptyList();
    }
}
