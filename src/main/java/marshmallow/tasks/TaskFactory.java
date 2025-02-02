package marshmallow.tasks;

import marshmallow.MarshmallowException;
import marshmallow.storage.textfilestorage.TextFileStorageConstructable;

/**
 * Factory class for creating tasks from save strings.
 */
public class TaskFactory implements TextFileStorageConstructable<Task> {
    public Task constructFromSaveString(String saveString) {
        Task task;

        String[] parts = saveString.split(" \\| ");
        boolean isDone = parts[1].equals("1");
        String description = parts[2].replace("||", "|");

        if (parts[0].equals("T")) {
            task = new Todo(description);
        } else if (parts[0].equals("E")) {
            task = new Event(description, parts[3], parts[4]);
        } else if (parts[0].equals("D")) {
            task = new Deadline(description, parts[3]);
        } else {
            throw new MarshmallowException("I encountered a task I don't recognise! Are you using an old version of Marshmallow?");
        }

        if (isDone) {
            task.mark();
        }

        return task;
    }
}
