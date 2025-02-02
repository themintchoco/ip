import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private static DateTimeFormatter dtfParse = DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm");
    private static DateTimeFormatter dtfDisplay = DateTimeFormatter.ofPattern("MMM dd yyyy HHmm");

    public Event(String description, String startTimeString, String endTimeString) {
        super(description);
        this.startTime = LocalDateTime.parse(startTimeString, dtfParse);
        this.endTime = LocalDateTime.parse(endTimeString, dtfParse);
    }

    @Override
    public String toSaveString() {
        return String.format("E | %s | %s | %s", super.toSaveString(), startTime.format(dtfParse), endTime.format(dtfParse));
    }

    @Override
    public String toString() {
        return String.format("[E]%s (from: %s to: %s)", super.toString(), startTime.format(dtfDisplay), endTime.format(dtfDisplay));
    }
}
