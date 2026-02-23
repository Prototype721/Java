package Task_3;

import java.util.Scanner;

public class NumTen {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] arrStr = line.split(", ");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++){
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        System.out.println(isTriangle(arr[0], arr[1], arr[2]));
    }
    public static boolean isTriangle(int num1, int num2, int num3){
        if (((num1+num2)>num3) && ((num1+num3)>num2) &&((num3+num2)>num1)){
            return true;
        }
        return false;
    }
}
