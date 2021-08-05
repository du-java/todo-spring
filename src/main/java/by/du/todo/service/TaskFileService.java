package by.du.todo.service;

import by.du.todo.model.Task;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TaskFileService extends AbstractFileService<Task> {

    @Value("${meeting-db}")
    private String path;

    @Override
    protected Function<String, Task> getParse() {
        return line -> {
            final String[] strings = line.split(",");
            final Task task = new Task();
            task.setId(Integer.parseInt(strings[0]));
            task.setDesc(strings[1]);
            task.setCompleted(Boolean.parseBoolean(strings[2]));
            return task;
        };
    }

    @Override
    protected String getPath() {
        return path;
    }
}
