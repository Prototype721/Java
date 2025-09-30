package Task_1;

import java.util.Scanner;

public class NumEight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(isPalindrome(s));
    }

    public static String reverseString(String s) {
        String revString = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            revString += s.charAt(i);
        }
        return revString;
    }

    public static boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }
}