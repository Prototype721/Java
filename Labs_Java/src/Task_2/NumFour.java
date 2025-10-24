package Task_2;

import java.util.Scanner;

public class NumFour {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numbers = input.split(", ");
        int[] arr = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            arr[i] = Integer.parseInt(numbers[i]);
        }
        System.out.println(hasDuplicates(arr));
    }

    public static boolean hasDuplicates(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    return true;
                }
            }
        }
        return false;
    }
}