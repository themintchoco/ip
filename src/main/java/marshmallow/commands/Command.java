package marshmallow.commands;

import marshmallow.tasks.TaskList;
import marshmallow.ui.Ui;

public abstract class Command {
    public boolean isExit;

    public abstract String handle(TaskList tasks, Ui ui);
}
