package Task_1;

import java.util.Scanner;

public class NumTwo {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double len = scanner.nextDouble();
        double wide = scanner.nextDouble();
        System.out.print(rectangleArea(len, wide));
    }

    public static double rectangleArea(double len, double wide){
        return len * wide;
    }
}
