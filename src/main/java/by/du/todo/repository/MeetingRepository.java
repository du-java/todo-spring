package by.du.todo.repository;

import by.du.todo.model.Meeting;
import by.du.todo.service.FileService;
import org.springframework.stereotype.Repository;

@Repository
public class MeetingRepository extends AbstractRepository<Meeting> {
    public MeetingRepository(final FileService<Meeting> fileService) {
        super(fileService);
    }
}
