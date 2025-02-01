public abstract class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
    }

    public static Task fromSaveString(String saveString) {
        Task task;

        String[] parts = saveString.split(" \\| ");
        boolean isDone = parts[1].equals("1");
        String description = parts[2].replace("||", "|");

        if (parts[0].equals("T")) {
            task = new Todo(description);
        } else if (parts[0].equals("E")) {
            task = new Event(description, parts[3], parts[4]);
        } else if (parts[0].equals("D")) {
            task = new Deadline(description, parts[3]);
        } else {
            throw new MarshmallowException("I encountered a task I don't recognise! Are you using an old version of Marshmallow?");
        }

        if (isDone) {
            task.mark();
        }

        return task;
    }

    public void mark() {
        this.isDone = true;
    }

    public void unmark() {
        this.isDone = false;
    }

    public String toSaveString() {
        return (isDone ? "1" : "0") + " | " + description.replace("|", "||");
    }

    @Override
    public String toString() {
        return (isDone ? "[X] " : "[ ] ") + description;
    }
}
