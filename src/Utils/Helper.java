package Utils;
import java.util.Scanner;

public class Helper {
    private static final Scanner sc = new Scanner(System.in);
    public static String readString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
}