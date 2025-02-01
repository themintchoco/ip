import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TaskStore {
    private List<Task> tasks;
    private File saveFile;

    public TaskStore() {
        this.tasks = new ArrayList<>();

        this.saveFile = new File("data/tasks.txt");
        this.saveFile.getParentFile().mkdirs();

        if (this.saveFile.exists()) {
            load();
        }
    }

    private void load() {
        try (FileReader reader = new FileReader(this.saveFile)) {
            int data;
            StringBuilder sb = new StringBuilder();
            while ((data = reader.read()) != -1) {
                if (data == '\n') {
                    tasks.add(Task.fromSaveString(sb.toString()));
                    sb.setLength(0);
                } else {
                    sb.append((char) data);
                }
            }
        } catch (IOException e) {
            throw new MarshmallowException("Something went wrong while loading your tasks :(");
        }
    }

    public void save() {
        try (FileWriter writer = new FileWriter(this.saveFile)) {
            for (Task task : tasks) {
                writer.write(task.toSaveString());
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new MarshmallowException("Something went wrong while saving your tasks :(");
        }
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
