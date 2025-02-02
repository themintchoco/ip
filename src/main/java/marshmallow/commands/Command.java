package marshmallow.commands;

import marshmallow.tasks.TaskList;
import marshmallow.ui.Ui;

/**
 * Represents a user command.
 */
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

    /**
     * Handles the command.
     *
     * @param tasks The task list.
     * @param ui The user interface.
     * @return The response to the user.
     */
    public abstract String handle(TaskList tasks, Ui ui);
}
