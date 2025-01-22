import java.util.Scanner;

public abstract class Command {
    public boolean isExit;

    public static Command parse(Scanner s) {
        String command = s.next();
        switch (command) {
        case "list":
            return new ListDisplayCommand();
        case "mark":
            return new ListTaskMarkCommand(s.nextInt() - 1);
        case "unmark":
            return new ListTaskUnmarkCommand(s.nextInt() - 1);
        case "bye":
            return new ExitCommand();
        default:
            return new ListAddCommand(command + s.nextLine());
        }
    }

    public abstract String handle(TaskStore store);
}
