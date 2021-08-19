package by.du.todo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "meetings")
@NoArgsConstructor
@AllArgsConstructor
public class Meeting implements Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String place;
    @Column(name = "start_event")
    private LocalDateTime start;
    @Column(name = "end_event")
    private LocalDateTime end;
    @Column(name = "description")
    private String desc;
}
