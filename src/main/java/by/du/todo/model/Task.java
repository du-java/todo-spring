package by.du.todo.model;

public class Task implements Event {

    private int id;
    private String desc;
    private boolean isCompleted;

    public Task(int id, String desc, boolean isCompleted) {
        this.id = id;
        this.desc = desc;
        this.isCompleted = isCompleted;
    }

    public Task() {
    }

    public Task(String desc) {
        this.desc = desc;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != task.id) return false;
        if (isCompleted != task.isCompleted) return false;
        return desc != null ? desc.equals(task.desc) : task.desc == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (isCompleted ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return id + "," + desc + "," + isCompleted;
    }
}
