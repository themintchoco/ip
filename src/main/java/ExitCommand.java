public class ExitCommand extends Command {
    public ExitCommand() {
        this.isExit = true;
    }

    @Override
    public String handle() {
        return "Bye. Hope to see you again soon!";
    }
}
