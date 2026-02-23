package Task_2;

import java.util.Scanner;

public class NumSeven {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = Math.abs(scanner.nextInt());
        int[] result = countEvenOddDigits(n);
        System.out.println(result[0] + ", " + result[1]);
    }

    public static int[] countEvenOddDigits(int n){
        int even = 0, odd = 0;
        if(n == 0) return new int[]{1, 0};
        while(n > 0){
            int digit = n % 10;
            if(digit % 2 == 0) even++;
            else odd++;
            n /= 10;
        }
        return new int[]{even, odd};
    }
}