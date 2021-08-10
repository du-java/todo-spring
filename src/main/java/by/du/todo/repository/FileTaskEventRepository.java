package by.du.todo.repository;

import by.du.todo.model.Task;
import by.du.todo.service.FileService;
import org.springframework.stereotype.Repository;

@Repository
public class FileTaskEventRepository extends FileAbstractEventRepository<Task> {
    public FileTaskEventRepository(final FileService<Task> fileService) {
        super(fileService);
    }
}
