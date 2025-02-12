package marshmallow.commands;

import marshmallow.tasks.TaskList;

public class ListFindTaskCommand extends Command {
    private String query;

    public ListFindTaskCommand(String query) {
        this.query = query;
    }

    @Override
    public String handle(TaskList tasks) {
        assert tasks != null : "Task list should not be null";

        StringBuilder sb = new StringBuilder();
        sb.append("Here are the matching tasks in your list:\n");
        sb.append(new TaskList(tasks.filterTasks(query)).toString());
        return sb.toString();
    }
}
