package Task_5;


import java.util.*;

public class NumNine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String[] parts = input.split(",");
        String s1 = parts[0].trim().replace("\"", "").replace("'", "");
        String s2 = parts[1].trim().replace("\"", "").replace("'", "");

        System.out.println(sameLetterPattern(s1, s2));
    }

    public static boolean sameLetterPattern(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        return getPattern(s1).equals(getPattern(s2));
    }

    private static String getPattern(String s) {
        StringBuilder pattern = new StringBuilder();
        Map<Character, Character> map = new HashMap<>();
        char nextChar = 'A';

        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, nextChar++);
            }
            pattern.append(map.get(c));
        }

        return pattern.toString();
    }
}