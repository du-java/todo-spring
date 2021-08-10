package by.du.todo.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Meeting implements Event {
    private int id;
    private String place;
    private LocalDateTime start;
    private LocalDateTime end;
    private String desc;
}
