package marshmallow.parser;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import marshmallow.MarshmallowException;
import marshmallow.commands.Command;
import marshmallow.commands.ExitCommand;
import marshmallow.commands.ListAddDeadlineCommand;
import marshmallow.commands.ListAddEventCommand;
import marshmallow.commands.ListAddTodoCommand;
import marshmallow.commands.ListDeleteTaskCommand;
import marshmallow.commands.ListDisplayCommand;
import marshmallow.commands.ListFindTaskCommand;
import marshmallow.commands.ListTaskMarkCommand;
import marshmallow.commands.ListTaskUnmarkCommand;

public class Parser {
    public Command parse(Scanner s) {
        String command = s.next();

        try {
            switch (command) {
            case "list":
                return new ListDisplayCommand();
            case "todo":
                return new ListAddTodoCommand(s.nextLine().trim());
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
            case "delete":
                return new ListDeleteTaskCommand(s.nextInt() - 1);
            case "find":
                return new ListFindTaskCommand(s.nextLine().trim());
            case "bye":
                return new ExitCommand();
            }
        } catch (InputMismatchException e) {
            s.nextLine();
            throw new MarshmallowException("Please follow the correct format for the command :(");
        }

        return null;
    }

    private Map<String, String> parseSwitches(String line) {
        Map<String, String> switches = new HashMap<>();
        String[] parts = line.split("/");
        switches.put("", parts[0].trim());
        for (int i = 1; i < parts.length; i++) {
            String[] kv = parts[i].split(" ", 2);
            switches.put(kv[0], kv[1].trim());
        }
        return switches;
    }
}
