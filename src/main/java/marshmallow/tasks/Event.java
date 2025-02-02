package marshmallow.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents an event task.
 */
public class Event extends Task {
    private static DateTimeFormatter dtfParse = DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm");
    private static DateTimeFormatter dtfDisplay = DateTimeFormatter.ofPattern("MMM dd yyyy HHmm");

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    /**
     * Constructor for an event.
     *
     * @param description The description of the event.
     * @param startTimeString The start time of the event. Must be in the format `dd-MM-yyyy HHmm`.
     * @param endTimeString The end time of the event. Must be in the format `dd-MM-yyyy HHmm`.
     */
    public Event(String description, String startTimeString, String endTimeString) {
        super(description);
        this.startTime = LocalDateTime.parse(startTimeString, dtfParse);
        this.endTime = LocalDateTime.parse(endTimeString, dtfParse);
    }

    @Override
    public String toSaveString() {
        return String.format("E | %s | %s | %s",
                super.toSaveString(),
                startTime.format(dtfParse),
                endTime.format(dtfParse));
    }

    @Override
    public String toString() {
        return String.format("[E]%s (from: %s to: %s)",
                super.toString(),
                startTime.format(dtfDisplay),
                endTime.format(dtfDisplay));
    }
}
