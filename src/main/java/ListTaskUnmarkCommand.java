public class ListTaskUnmarkCommand extends Command {
    private int idx;

    public ListTaskUnmarkCommand(int idx) {
        this.idx = idx;
    }

    @Override
    public String handle(TaskStore store) {
        Task task = store.getTask(idx);
        task.unmark();
        store.save();
        return String.format("OK, I've marked this task as not done yet:\n  %s", task);
    }
}
