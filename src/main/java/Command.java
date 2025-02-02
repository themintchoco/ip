public abstract class Command {
    public boolean isExit;

    public abstract String handle(TaskList tasks, Ui ui);
}
