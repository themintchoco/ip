public class ListTaskUnmarkCommand extends Command {
    private int idx;

    public ListTaskUnmarkCommand(int idx) {
        this.idx = idx;
    }

    @Override
    public String handle(TaskList tasks, Ui ui) {
        Task task = tasks.getTask(idx);
        task.unmark();
        tasks.save();
        return String.format("OK, I've marked this task as not done yet:\n  %s", task);
    }
}
