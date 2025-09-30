package Task_1;

import java.util.Scanner;

public class NumSeven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        int average = average(num1, num2, num3);
        System.out.println(average);
    }

    public static int average(int a, int b, int c) {
        return (a + b + c) / 3;
    }
}
