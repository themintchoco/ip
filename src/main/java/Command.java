import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Command {
    public boolean isExit;

    public static Command parse(Scanner s) {
        String command = s.next();
        switch (command) {
        case "list":
            return new ListDisplayCommand();
        case "todo":
            return new ListAddTodoCommand(s.nextLine());
        case "deadline":
            Map<String, String> deadlineSwitches = parseSwitches(s.nextLine());
            return new ListAddDeadlineCommand(deadlineSwitches.get(""), deadlineSwitches.get("by"));
        case "event":
            Map<String, String> eventSwitches = parseSwitches(s.nextLine());
            return new ListAddEventCommand(eventSwitches.get(""), eventSwitches.get("from"), eventSwitches.get("to"));
        case "mark":
            return new ListTaskMarkCommand(s.nextInt() - 1);
        case "unmark":
            return new ListTaskUnmarkCommand(s.nextInt() - 1);
        case "bye":
            return new ExitCommand();
        }

        return null;
    }

    private static Map<String, String> parseSwitches(String line) {
        Map<String, String> switches = new HashMap<>();
        String[] parts = line.split("/");
        switches.put("", parts[0].trim());
        for (int i = 1; i < parts.length; i++) {
            String[] kv = parts[i].split(" ", 2);
            switches.put(kv[0], kv[1].trim());
        }
        return switches;
    }

    public abstract String handle(TaskStore store);
}
