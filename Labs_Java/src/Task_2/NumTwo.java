package Task_2;

import java.util.Scanner;

public class NumTwo {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numbers = input.split(", ");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);
        System.out.println(sumRange(a, b));
    }

    public static int sumRange(int a, int b){
        int sum = 0;
        for(int i = a; i <= b; i++){
            sum += i;
        }
        return sum;
    }
}