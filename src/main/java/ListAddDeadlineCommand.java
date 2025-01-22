public class ListAddDeadlineCommand extends ListAddTaskCommand {
    public ListAddDeadlineCommand(String description, String endTime) {
        this.task = new Deadline(description, endTime);
    }
}
