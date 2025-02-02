public class ListDisplayCommand extends Command {
    @Override
    public String handle(TaskList tasks, Ui ui) {
        return tasks.toString();
    }
}
