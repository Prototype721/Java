package Task_1;

import java.util.Scanner;
import java.lang.Math;

public class NumTree {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.print(digitSum(num));
    }

    public static int digitSum(int num){
        num = Math.abs(num);
        int sumOfNum = 0;
        for (int i=0; i < 7;i++){
            double power = Math.pow(10.0, (double)i);
            sumOfNum += (int)(num/power)%10;
        }
        return sumOfNum;
    }
}