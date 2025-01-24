public class ListAddEventCommand extends ListAddTaskCommand {
    public ListAddEventCommand(String description, String startTime, String endTime) {
        if (startTime == null) {
            throw new MarshmallowException("Please tell me when this event starts!");
        }

        if (endTime == null) {
            throw new MarshmallowException("Please tell me when this event ends!");
        }

        this.task = new Event(description, startTime, endTime);
    }
}
