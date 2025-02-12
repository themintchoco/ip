package marshmallow.commands;

import marshmallow.tasks.Task;
import marshmallow.tasks.TaskList;

public class ListDeleteTaskCommand extends Command {
    private int idx;

    public ListDeleteTaskCommand(int idx) {
        this.idx = idx;
    }

    @Override
    public String handle(TaskList tasks) {
        assert tasks != null : "Task list should not be null";

        Task task = tasks.removeTask(idx);
        return String.format("Noted. I've removed this task:\n  %s\nNow you have %d tasks in the list.",
                task,
                tasks.count());
    }
}
