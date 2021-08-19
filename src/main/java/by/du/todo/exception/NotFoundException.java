package by.du.todo.exception;

public class NotFoundException extends RuntimeException {
    private String message;
    private long id;

    public NotFoundException(long id) {
        this.id = id;
    }
}
