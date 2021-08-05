package by.du.todo.service;

import by.du.todo.model.Event;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractFileService<T extends Event> implements FileService<T> {

    protected abstract String getPath();

    protected abstract Function<String, T> getParse();

    @Override
    public List<T> load() {
        try {
            return Files.lines(Paths.get(getPath()))
                    .map(getParse())
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public void store(final List<T> list) {
        try {
            Files.write(Paths.get(getPath()), list.stream().map(Object::toString).collect(Collectors.toList()));
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
