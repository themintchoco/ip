public class Deadline extends Task {
    private String endTime;

    public Deadline(String description, String endTime) {
        super(description);
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(), endTime);
    }
}
