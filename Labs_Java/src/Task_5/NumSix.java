package Task_5;

import java.util.*;

public class NumSix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String[] parts = input.split(",");
        String s1 = parts[0].trim().replace("\"", "").replace("'", "");
        String s2 = parts[1].trim().replace("\"", "").replace("'", "");

        System.out.println(findShift(s1, s2));
    }

    public static int findShift(String s1, String s2) {
        if (s1.length() != s2.length())
            return -1;

        for (int shift = 0; shift < 26; shift++) {
            boolean match = true;
            for (int i = 0; i < s1.length(); i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);

                char shifted = (char) ('a' + (c1 - 'a' + shift) % 26);
                if (c1 != ' ' && shifted != c2) {
                    match = false;
                    break;
                }
            }
            if (match)
                return shift;
        }
        return -1;
    }
}