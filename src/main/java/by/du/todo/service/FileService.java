package by.du.todo.service;

import by.du.todo.model.Event;

import java.util.List;

public interface FileService<T extends Event> {

    List<T> load();

    void store(List<T> list);

}
