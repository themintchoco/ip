public class ExitCommand extends Command {
    public ExitCommand() {
        this.isExit = true;
    }

    @Override
    public String handle(TaskList tasks, Ui ui) {
        return "Bye. Hope to see you again soon!";
    }
}
