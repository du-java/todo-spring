package by.du.todo.repository;

import by.du.todo.model.Event;
import by.du.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByCompletedTrue();
    List<Task> findAllByCompletedFalse();
}
