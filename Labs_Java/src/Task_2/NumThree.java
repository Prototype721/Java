package Task_2;

import java.util.Scanner;

public class NumThree {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numbers = input.split(", ");
        int[] arr = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            arr[i] = Integer.parseInt(numbers[i]);
        }
        System.out.println(sumOfPositives(arr));
    }

    public static int sumOfPositives(int[] arr){
        int sum = 0;
        for(int num : arr){
            if(num > 0){
                sum += num;
            }
        }
        return sum;
    }
}