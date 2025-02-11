package marshmallow.commands;

import marshmallow.tasks.TaskList;

public class ExitCommand extends Command {
    public ExitCommand() {
        this.isExit = true;
    }

    @Override
    public String handle(TaskList tasks) {
        return "Bye. Hope to see you again soon!";
    }
}
