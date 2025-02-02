package marshmallow.commands;

import marshmallow.tasks.TaskList;
import marshmallow.ui.Ui;

public class ListDisplayCommand extends Command {
    @Override
    public String handle(TaskList tasks, Ui ui) {
        return tasks.toString();
    }
}
