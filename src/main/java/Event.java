public class Event extends Task {
    private String startTime;
    private String endTime;

    public Event(String description, String startTime, String endTime) {
        super(description);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String toSaveString() {
        return String.format("E | %s | %s | %s", super.toSaveString(), startTime, endTime);
    }

    @Override
    public String toString() {
        return String.format("[E]%s (from: %s to: %s)", super.toString(), startTime, endTime);
    }
}
