package Task_3;

import java.util.Arrays;
import java.util.Scanner;

public class NumThree {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        line = line.substring(1, line.length()-1);
        String[] arrStr = line.split(", ");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++){
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        System.out.println(secondLargest(arr));
    }
    public static int secondLargest(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-2];

    }

}
