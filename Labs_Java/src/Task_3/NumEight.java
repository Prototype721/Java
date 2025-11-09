package Task_3;

import java.util.Scanner;

public class NumEight {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println(fibonacci(scanner.nextInt()));
    }
    public static int fibonacci(int index){
        switch (index){
            case 0: return 0;
            case 1: return 1;
            case 2: return 1;
            default: return fibonacci(index-1) + fibonacci(index-2);
        }
    }
}
