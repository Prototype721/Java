package Task_2;

import java.util.Scanner;

public class NumFive {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split("], ");
        String partZero = parts[0];

        if ((partZero.equals("["))){
            System.out.println("[]");
        }
        else {
            String[] numbers = partZero.substring(1).split(", ");
            int k = Integer.parseInt(parts[1]);

            int[] arr = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                arr[i] = Integer.parseInt(numbers[i]);
            }

            int[] result = rotateRight(arr, k);
            System.out.print("[");
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
                if (i < result.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }

    public static int[] rotateRight(int[] arr, int k){
        if(arr.length == 0) return arr;
        k = k % arr.length;
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            result[(i + k) % arr.length] = arr[i];
        }
        return result;
    }
}