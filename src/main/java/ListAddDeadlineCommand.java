public class ListAddDeadlineCommand extends ListAddTaskCommand {
    public ListAddDeadlineCommand(String description, String endTime) {
        if (endTime == null) {
            throw new MarshmallowException("Please tell me when you need to do this by!");
        }

        this.task = new Deadline(description, endTime);
    }
}
