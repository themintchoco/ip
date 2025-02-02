public abstract class Task implements TextFileStorageSaveable {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
    }

    public void mark() {
        this.isDone = true;
    }

    public void unmark() {
        this.isDone = false;
    }

    @Override
    public String toSaveString() {
        return (isDone ? "1" : "0") + " | " + description.replace("|", "||");
    }

    @Override
    public String toString() {
        return (isDone ? "[X] " : "[ ] ") + description;
    }
}
