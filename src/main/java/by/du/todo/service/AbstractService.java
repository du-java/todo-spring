package by.du.todo.service;

import by.du.todo.model.Event;
import by.du.todo.repository.EventRepository;

import java.util.List;

public abstract class AbstractService<T extends Event> implements Service<T> {

    private final EventRepository<T> eventRepository;

    public AbstractService(final EventRepository<T> eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public T getById(final int id) {
        return eventRepository.getById(id);
    }

    @Override
    public void add(final T t) {
        eventRepository.add(t);
    }

    @Override
    public List<T> getAll() {
        return eventRepository.getAll();
    }

    @Override
    public void save(final T t) {
        eventRepository.save(t);
    }

    public void delete(final int id){
        eventRepository.delete(id);
    }
}
