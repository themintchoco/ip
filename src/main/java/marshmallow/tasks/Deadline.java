package marshmallow.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private static DateTimeFormatter dtfParse = DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm");
    private static DateTimeFormatter dtfDisplay = DateTimeFormatter.ofPattern("MMM dd yyyy HHmm");

    private LocalDateTime endTime;

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
