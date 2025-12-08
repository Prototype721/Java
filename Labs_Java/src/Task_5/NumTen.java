package Task_5;


import java.util.*;

public class NumTen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String[] parts = input.split(",");
        int a = Integer.parseInt(parts[0].trim());
        int b = Integer.parseInt(parts[1].trim());

        System.out.println(memeSum(a, b));
    }

    public static int memeSum(int a, int b) {
        StringBuilder result = new StringBuilder();

        while (a > 0 || b > 0) {
            int digitA = a % 10;
            int digitB = b % 10;
            int sum = digitA + digitB;

            result.insert(0, sum);

            a /= 10;
            b /= 10;
        }

        return Integer.parseInt(result.toString());
    }
}