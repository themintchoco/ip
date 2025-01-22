import java.util.Scanner;

public abstract class Command {
    public boolean isExit;

    public static Command parse(Scanner s) {
        String command = s.next();
        switch (command) {
        case "bye":
            return new ExitCommand();
        default:
            return new EchoCommand(command + s.nextLine());
        }
    }

    public abstract String handle();
}
