package by.du.todo.service;

import by.du.todo.model.Event;

import java.util.List;

public interface Service<T extends Event> {
    T getById(long id);

    void add(T t);

    List<T> getAll();

    void save(T t);

    void delete(long id);

}
