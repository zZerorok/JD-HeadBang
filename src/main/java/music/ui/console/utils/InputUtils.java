package music.ui.console.utils;

import java.util.Scanner;

public class InputUtils {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String nextLine() {
        return SCANNER.nextLine();
    }

    public static String nextLine(String text) {
        System.out.print(text + ": ");
        return SCANNER.nextLine();
    }
}
