package marshmallow.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a deadline task.
 */
public class Deadline extends Task {
    private static DateTimeFormatter dtfParse = DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm");
    private static DateTimeFormatter dtfDisplay = DateTimeFormatter.ofPattern("MMM dd yyyy HHmm");

    private LocalDateTime endTime;

    /**
     * Constructor for a deadline.
     *
     * @param description The description of the deadline.
     * @param endTimeString The end time of the deadline. Must be in the format `dd-MM-yyyy HHmm`.
     */
    public Deadline(String description, String endTimeString) {
        super(description);
        this.endTime = LocalDateTime.parse(endTimeString, dtfParse);
    }

    @Override
    public String toSaveString() {
        return String.format("D | %s | %s", super.toSaveString(), endTime.format(dtfParse));
    }

    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(), endTime.format(dtfDisplay));
    }
}
