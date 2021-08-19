package by.du.todo.service;

import by.du.todo.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractService<T extends Event> implements Service<T> {

    private final JpaRepository<T, Long> eventRepository;

    public AbstractService(final JpaRepository<T, Long> eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public T getById(final long id) {
        return eventRepository.getById(id);
    }

    @Override
    public void add(final T t) {
        eventRepository.save(t);
    }

    @Override
    public List<T> getAll() {
        return eventRepository.findAll();
    }

    @Override
    public void save(final T t) {
        eventRepository.save(t);
    }

    public void delete(final long id) {
        eventRepository.deleteById(id);
    }
}
