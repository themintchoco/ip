package marshmallow.tasks;

import marshmallow.storage.textfilestorage.TextFileStorageSaveable;

/**
 * Represents a task.
 */
public abstract class Task implements TextFileStorageSaveable {
    private String description;
    private boolean isDone;

    /**
     * Constructor for a task.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
    }

    /**
     * Marks the task as done.
     */
    public void mark() {
        this.isDone = true;
    }

    /**
     * Unmarks the task as done.
     */
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
