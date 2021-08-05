package by.du.todo.service;

import by.du.todo.model.Task;
import by.du.todo.repository.TaskRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskService extends AbstractService<Task> {

    private final TaskRepository taskRepository;

    public TaskService(final TaskRepository taskRepository) {
        super(taskRepository);
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllNotCompleted() {
        return taskRepository.getAllBy(x -> !x.isCompleted());
    }

    public List<Task> getAllCompleted() {
        return taskRepository.getAllBy(Task::isCompleted);
    }

}
