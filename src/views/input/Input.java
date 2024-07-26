package views.input;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readNumber() {
        int option = 0;
        option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    public static String readText() {
        String text = "";
        text = scanner.nextLine();
        return text;
    }
}
