package Task_1;

import java.util.Scanner;

public class NumFor {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.print(isEven(num));
    }

    public static boolean isEven(int num){
        if (num%2==0){
            return true;
        }
        else {
            return false;
        }
    }
}