package by.du.todo.controller;

import by.du.todo.exception.NotFoundException;
import by.du.todo.model.Meeting;
import by.du.todo.repository.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MeetingRepository meetingRepository;

    @GetMapping("/home")
    public ModelAndView home() {
        final long id = 1l;
        final Meeting meeting = meetingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));

        final ModelAndView modelAndView = new ModelAndView("home");

        modelAndView.addObject("meeting", meeting);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView home1() {
        final Meeting meeting = new Meeting();
        meeting.setDesc("desc1");
        meeting.setPlace("place1");
        meeting.setStart(LocalDateTime.now());
        meeting.setEnd(LocalDateTime.now());
        meetingRepository.save(meeting);
        final ModelAndView modelAndView = new ModelAndView("home");

        modelAndView.addObject("meeting", meeting);

        return modelAndView;
    }
}
