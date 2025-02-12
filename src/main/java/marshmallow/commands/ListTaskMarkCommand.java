package marshmallow.commands;

import marshmallow.tasks.Task;
import marshmallow.tasks.TaskList;

public class ListTaskMarkCommand extends Command {
    private int idx;

    public ListTaskMarkCommand(int idx) {
        this.idx = idx;
    }

    @Override
    public String handle(TaskList tasks) {
        assert tasks != null : "Task list should not be null";

        Task task = tasks.getTask(idx);
        task.mark();
        tasks.save();
        return String.format("Nice! I've marked this task as done:\n  %s", task);
    }
}
