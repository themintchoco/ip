package marshmallow.commands;

import marshmallow.tasks.TaskList;

public class ListDisplayCommand extends Command {
    @Override
    public String handle(TaskList tasks) {
        return tasks.toString();
    }
}
