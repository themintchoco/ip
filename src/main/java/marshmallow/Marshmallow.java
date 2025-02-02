package marshmallow;

import java.util.Scanner;

import marshmallow.commands.Command;
import marshmallow.parser.Parser;
import marshmallow.storage.textfilestorage.TextFileStorage;
import marshmallow.tasks.Task;
import marshmallow.tasks.TaskFactory;
import marshmallow.tasks.TaskList;
import marshmallow.ui.Ui;

public class Marshmallow {
    private TextFileStorage<Task, TaskFactory> storage;
    private TaskList tasks;
    private Ui ui;

    public Marshmallow(String path) {
        ui = new Ui();
        storage = new TextFileStorage<>("data/tasks.txt", new TaskFactory());
        tasks = new TaskList(storage);

        ui.greet();
    }

    public void run() {
        Parser parser = new Parser();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    Command command = parser.parse(scanner);

                    if (command == null) {
                        ui.respond("I'm sorry, but I don't know what that means :(");
                        continue;
                    }

                    ui.respond(command.handle(tasks, ui));

                    if (command.isExit) {
                        break;
                    }
                } catch (MarshmallowException e) {
                    ui.respond(e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        new Marshmallow("data/tasks.txt").run();
    }
}
