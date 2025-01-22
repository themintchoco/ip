public class ListDisplayCommand extends Command {
    @Override
    public String handle(TaskStore store) {
        return store.toString();
    }
}
