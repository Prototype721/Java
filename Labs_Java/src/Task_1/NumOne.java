package Task_1;

import java.util.Scanner;

public class NumOne {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double celcius = scanner.nextDouble();
        System.out.print(toFahrenheit(celcius));
    }

    public static double toFahrenheit(double celcius){
        return celcius * 1.8 + 32;
    }
}
