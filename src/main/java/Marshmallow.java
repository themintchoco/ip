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
        System.out.println(logo);

        respond("Hello! I'm Marshmallow\nWhat can I do for you?");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                respond("Bye. Hope to see you again soon!");
                break;
            } else {
                respond(input);
            }
        }

        scanner.close();
    }
}
