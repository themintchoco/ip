public class ListTaskMarkCommand extends Command {
    private int idx;

    public ListTaskMarkCommand(int idx) {
        this.idx = idx;
    }

    @Override
    public String handle(TaskStore store) {
        Task task = store.getTask(idx);
        task.mark();
        return String.format("Nice! I've marked this task as done:\n  %s", task);
    }
}
