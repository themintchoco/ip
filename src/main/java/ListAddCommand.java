public class ListAddCommand extends Command {
    private String description;

    public ListAddCommand(String description) {
        this.description = description;
    }

    @Override
    public String handle(TaskStore store) {
        store.addTask(new Task(description));
        return String.format("added: %s", description);
    }
}
