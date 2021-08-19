package by.du.todo.controller;

import by.du.todo.dto.MeetingRequest;
import by.du.todo.exception.NotFoundException;
import by.du.todo.model.Meeting;
import by.du.todo.repository.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/v1/meeting")
@RestController
@RequiredArgsConstructor
public class MeetingController {

    private final MeetingRepository meetingRepository;

    @GetMapping("/")
    public ResponseEntity<Page<Meeting>> findAll(Pageable pageable) {
        return ResponseEntity.ok(meetingRepository.findAll(pageable));
    }

    @GetMapping("/{meetingId}")
    public ResponseEntity<Meeting> findById(@PathVariable("meetingId") Long id) {
        final Meeting meeting = meetingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        return ResponseEntity.ok(meeting);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Meeting> create(@Valid @RequestBody MeetingRequest request) {
        final Meeting meeting = new Meeting();
        BeanUtils.copyProperties(request, meeting);

        final Meeting saved = meetingRepository.save(meeting);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/")
    public ResponseEntity<Meeting> update(@Valid @RequestBody MeetingRequest request) {
        final Meeting meeting = meetingRepository.findById(request.getId())
                .orElseThrow(() -> new NotFoundException(request.getId()));

        BeanUtils.copyProperties(request, meeting);

        final Meeting saved = meetingRepository.save(meeting);
        return ResponseEntity.accepted().body(saved);
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> delete(@Valid @RequestBody MeetingRequest request) {
        meetingRepository.deleteById(request.getId());
        return ResponseEntity.accepted().build();
    }

}
