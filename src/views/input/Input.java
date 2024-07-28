package views.input;

import java.time.LocalDate;
import java.time.LocalTime;
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

    public static LocalDate readDate() {
        String dateIn = "";
        dateIn = scanner.nextLine();
        return LocalDate.parse(dateIn);
    }

    public static LocalTime readTime() {
        String timeIn = "";
        timeIn = scanner.nextLine();
        return LocalTime.parse(timeIn);
    }
}
