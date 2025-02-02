package marshmallow.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import marshmallow.MarshmallowException;
import marshmallow.storage.Storage;

public class TaskList {
    private List<Task> tasks;
    private Storage<Task> storage;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList(Storage<Task> storage) {
        this.storage = storage;
        this.tasks = storage.load();
    }

    public void save() {
        if (storage == null) {
            return;
        }

        storage.save(tasks);
    }

    public void addTask(Task task) {
        tasks.add(task);
        save();
    }

    public Task removeTask(int index) {
        Task removedTask;

        try {
            removedTask = tasks.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new MarshmallowException("I can't find that task! Which one are you referring to?");
        }

        save();
        return removedTask;
    }

    public Task getTask(int index) {
        try {
            return tasks.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new MarshmallowException("I can't find that task! Which one are you referring to?");
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public int count() {
        return tasks.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ListIterator<Task> it = tasks.listIterator(); it.hasNext(); ) {
            sb.append(it.nextIndex() + 1).append(".").append(it.next());

            if (it.hasNext()) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}
