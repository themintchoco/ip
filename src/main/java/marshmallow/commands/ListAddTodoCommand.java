package marshmallow.commands;

import marshmallow.MarshmallowException;
import marshmallow.tasks.Todo;

public class ListAddTodoCommand extends ListAddTaskCommand {
    public ListAddTodoCommand(String description) {
        if (description.isEmpty()) {
            throw new MarshmallowException("Please tell me what you need to do!");
        }

        this.task = new Todo(description);
    }
}
