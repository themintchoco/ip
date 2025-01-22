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
                Command command = Command.parse(scanner);
                String response = command.handle(store);
                respond(response);

                if (command.isExit) {
                    break;
                }
            }
        }
    }
}
