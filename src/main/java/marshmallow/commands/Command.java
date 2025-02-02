package marshmallow.commands;

import marshmallow.tasks.TaskList;
import marshmallow.ui.Ui;

public abstract class Command {
    protected boolean isExit;

    /**
     * Returns true if and only if the command should cause the program to exit.
     *
     * @return true if the command should cause the program to exit, false otherwise
     */
    public boolean isExit() {
        return isExit;
    }

    public abstract String handle(TaskList tasks, Ui ui);
}
