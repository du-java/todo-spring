package by.du.todo.repository;

import by.du.todo.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {

    List<Meeting> findAllByStart(LocalDate localDate);

//    List<Meeting> findAllByStartGreaterThanAndEndLessThan(LocalDate from, LocalDate to);

    List<Meeting> findAllByPlace(String place);

    @Query("select m from Meeting m where m.place = :place")
    List<Meeting> findAll(@Param("place") String place);
}
