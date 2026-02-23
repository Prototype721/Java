package Task_5;


import java.util.*;

public class NumSeven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        input = input.trim().replaceAll("[\\[\\]]", "");
        String[] parts = input.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        System.out.println(maxEvenSubarray(arr));
    }

    public static int maxEvenSubarray(int[] arr) {
        int maxEven = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (i == 0 && j == arr.length - 1) {
                    continue;
                }
                if (sum % 2 == 0 && sum > maxEven) {
                    maxEven = sum;
                }
            }
        }
        return maxEven;
    }
}