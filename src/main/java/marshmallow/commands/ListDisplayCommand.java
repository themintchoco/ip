package marshmallow.commands;

import marshmallow.tasks.TaskList;

public class ListDisplayCommand extends Command {
    @Override
    public String handle(TaskList tasks) {
        assert tasks != null : "Task list should not be null";

        return tasks.toString();
    }
}
