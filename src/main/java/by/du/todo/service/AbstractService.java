package by.du.todo.service;

import by.du.todo.model.Event;
import by.du.todo.repository.Repository;

import java.util.List;

public abstract class AbstractService<T extends Event> implements Service<T> {

    private final Repository<T> repository;

    public AbstractService(final Repository<T> repository) {
        this.repository = repository;
    }

    @Override
    public T getById(final int id) {
        return repository.getById(id);
    }

    @Override
    public void add(final T t) {
        repository.add(t);
    }

    @Override
    public List<T> getAll() {
        return repository.getAll();
    }

    @Override
    public void save(final T t) {
        repository.save(t);
    }

    public void delete(final int id){
        repository.delete(id);
    }
}
