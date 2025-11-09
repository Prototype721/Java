package Task_3;


import java.util.Scanner;

public class NumFour {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(sumOfDigits(line));
    }
    public static int sumOfDigits(String line){
        int total = 0;
        for (char num : line.toCharArray()){
            total += Character.getNumericValue(num);
        }
        return total;
    }
}
