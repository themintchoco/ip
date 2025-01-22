public class ListAddEventCommand extends ListAddTaskCommand {
    public ListAddEventCommand(String description, String startTime, String endTime) {
        this.task = new Event(description, startTime, endTime);
    }
}
