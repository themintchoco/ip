package marshmallow.commands;

import marshmallow.tasks.Task;
import marshmallow.tasks.TaskList;

public abstract class ListAddTaskCommand extends Command {
    protected Task task;

    @Override
    public String handle(TaskList tasks) {
        tasks.addTask(task);
        return String.format("Got it. I've added this task:\n  %s\nNow you have %d tasks in the list.",
                task,
                tasks.count());
    }
}
