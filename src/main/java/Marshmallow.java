import java.util.Scanner;

public class Marshmallow {
    private static String logo = "⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⡀⠀⠀⠀⠀\n" +
                "⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠀\n" +
                "⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁\n" +
                "⡂⠀⠀⠀⠀⠀⠀⠀⠀⢠⣶⡄⠀⠀⠀⠀⠀⠀⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀⡀\n" +
                "⠂⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠁⠀⠀⠀⠀⠀⠀⠙⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠄\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠦⠤⠶⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⢨⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⠀⠀⠀⠆\n" +
                "⠈⠀⣀⢴⣛⢽⣱⢮⣦⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣔⡎⠷⣇⣏⠯⣆⠀⠁\n" +
                "⠀⢤⣿⣾⢯⣟⡳⣟⣾⣻⡧⠀⠀⠀⠀⢀⠀⠀⢀⣾⣵⡞⣯⢷⡺⡽⣏⠁⠀\n" +
                "⠀⢽⢿⣞⣛⣮⡟⣯⣷⣻⣾⡁⠀⠀⠀⠠⢨⣀⣾⣟⡾⣽⡿⣼⣹⢧⡻⢏⠀\n" +
                "⠄⢼⢿⣽⣿⣗⡿⣽⡻⣿⡶⡇⠄⣀⠀⠀⠻⢿⣹⢾⣽⢯⣷⣳⢯⡯⣟⠃⠀\n" +
                "⠀⠈⢺⣽⢟⣽⡳⢯⣳⣽⡷⣃⠄⡩⠐⣀⢂⠘⢻⣞⣿⢾⡽⣻⡺⡗⠉⠀⠀\n" +
                "⠀⠀⠀⣙⠻⣟⣯⣿⣽⡛⢹⠛⠛⠛⠛⠒⠙⠀⠚⡻⢽⣻⣯⣿⡟⠁⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠉⠉⠈⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠁⠀⠀⠀⠀⠀";

    private static void respond(String response) {
        System.out.println("    ________________________________________________________");
        System.out.print("     ");
        System.out.println(response.replace("\n", "\n     "));
        System.out.println("    ________________________________________________________\n");
    }

    public static void main(String[] args) {
        TaskStore store = new TaskStore();

        System.out.println(logo);
        respond("Hello! I'm Marshmallow\nWhat can I do for you?");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    Command command = Command.parse(scanner);

                    if (command == null) {
                        respond("I'm sorry, but I don't know what that means :(");
                        continue;
                    }

                    respond(command.handle(store));

                    if (command.isExit) {
                        break;
                    }
                } catch (MarshmallowException e) {
                    respond(e.getMessage());
                }
            }
        }
    }
}
