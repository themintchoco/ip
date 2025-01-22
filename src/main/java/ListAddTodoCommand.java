public class ListAddTodoCommand extends ListAddTaskCommand {
    public ListAddTodoCommand(String description) {
        this.task = new Todo(description);
    }
}
