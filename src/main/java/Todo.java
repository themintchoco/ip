public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    public String toSaveString() {
        return String.format("T | %s", super.toSaveString());
    }

    @Override
    public String toString() {
        return String.format("[T]%s", super.toString());
    }
}
