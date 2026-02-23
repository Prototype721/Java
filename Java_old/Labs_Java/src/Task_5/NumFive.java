package Task_5;


import java.util.*;

public class NumFive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().replaceAll("[\\[\\]]", "").split(",");
        scanner.close();

        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        System.out.println(isLandscape(arr));
    }

    public static boolean isLandscape(int[] arr) {
        if (arr.length < 3)
            return false;

        int peak = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[peak]) {
                peak = i;
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (!set.add(num))
                return false;
        }

        for (int i = 1; i <= peak; i++) {
            if (arr[i] <= arr[i - 1])
                return false;
        }

        for (int i = peak + 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1])
                return false;
        }

        return peak > 0 && peak < arr.length - 1;
    }
}