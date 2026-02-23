package Task_5;

import java.util.*;

public class NumOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        System.out.println(uniqueOrder(input));
    }

    public static String uniqueOrder(String str) {
        StringBuilder result = new StringBuilder();
        boolean[] seen = new boolean[65536];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!seen[c]) {
                seen[c] = true;
                result.append(c);
            }
        }
        return result.toString();
    }
}
