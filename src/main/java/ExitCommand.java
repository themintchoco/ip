public class ExitCommand extends Command {
    public ExitCommand() {
        this.isExit = true;
    }

    @Override
    public String handle(TaskStore store) {
        return "Bye. Hope to see you again soon!";
    }
}
