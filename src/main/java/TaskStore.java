import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TaskStore {
    private List<Task> tasks;

    public TaskStore() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(int index) {
        tasks.remove(index);
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ListIterator<Task> it = tasks.listIterator(); it.hasNext(); ) {
            sb.append(it.nextIndex() + 1).append(". ").append(it.next());

            if (it.hasNext()) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}
