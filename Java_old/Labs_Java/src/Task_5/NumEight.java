package Task_5;


import java.util.*;

public class NumEight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().replaceAll("[\\[\\]]", "").split(",");
        scanner.close();
        double[] arr = new double[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Double.parseDouble(parts[i].trim());
        }
        System.out.println(spread(arr));
    }

    public static double spread(double[] arr) {
        if (arr.length == 0)
            return 0;

        double min = arr[0];
        double max = arr[0];
        double sum = 0;

        for (double num : arr) {
            if (num < min)
                min = num;
            if (num > max)
                max = num;
            sum += num;
        }

        double average = sum / arr.length;
        if (average == 0)
            return 0;

        return (max - min) / average;
    }
}