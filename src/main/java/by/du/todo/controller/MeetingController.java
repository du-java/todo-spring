package by.du.todo.controller;

import by.du.todo.exception.StopException;
import by.du.todo.model.Meeting;
import by.du.todo.service.InputService;
import by.du.todo.service.MeetingService;
import by.du.todo.service.TranslateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;



@Component
@RequiredArgsConstructor
public class MeetingController {

    private final InputService inputService;
    private final MeetingService meetingService;
    private final FilteredMeetingController filteredMeetingController;
    private final EditMeetingController editMeetingController;
    private final TranslateService translateService;

    public void show() {
        while (true) {
            System.out.println("Meetings");
            System.out.println("1 - " + translateService.getString("addMeeting"));
            System.out.println("2 - " + translateService.getString("allMeetings"));
            System.out.println("3 - " + translateService.getString("showFiltered"));
            System.out.println("4 - " + translateService.getString("editMeeting"));
            System.out.println("5 - " + translateService.getString("deleteMeeting"));
            System.out.println("0 - " + translateService.getString("return"));
            System.out.println("------------------------");
            final int nextInt = inputService.nextInt();
            switch (nextInt) {
                case 1:
                    add();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    filteredMeetingController.show();
                    break;
                case 4:
                    editMeetingController.show();
                    break;
                case 5:
                    delete();
                    break;
                case 0:
                    return;
                default:
            }
        }
    }

    public void add() {
        System.out.println("Adding a new Meeting");
        final String place = inputService.getLine("Input Place: ");
        LocalDateTime start;
        LocalDateTime end;
        try {
            start = inputService.getLocalDateTime("Input Start date and time (%s): ");
            end = inputService.getLocalDateTime("Input End date and time (%s): ");
        } catch (StopException ex) {
            return;
        }
        final String desc = inputService.getLine("Input Description: ");
        meetingService.add(new Meeting(place, start, end, desc));
        System.out.println("\nNew Meeting was added successfully\n");
    }

    public void showAll() {
        System.out.println("Showing all meetings");
        meetingService.getAll().forEach(System.out::println);
        System.out.println();
    }

    public void delete() {
        int id = inputService.nextInt("Input id to delete");
        meetingService.delete(id);
    }
}
