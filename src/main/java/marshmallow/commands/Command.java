package marshmallow.commands;

import marshmallow.tasks.TaskList;
import marshmallow.ui.Ui;

/**
 * Represents a user command.
 */
public abstract class Command {
    /// Whether this command is an exit command.
    public boolean isExit;

    /**
     * Handles the command.
     *
     * @param tasks The task list.
     * @param ui The user interface.
     * @return The response to the user.
     */
    public abstract String handle(TaskList tasks, Ui ui);
}
