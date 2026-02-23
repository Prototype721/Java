package Task_1;

import java.util.Scanner;

public class NumTen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        System.out.println(season(month));
    }
    public static String season(int month) {
        switch (month) {
            case 12:
            case 1:
            case 2:
                return "зима";
            case 3:
            case 4:
            case 5:
                return "весна";
            case 6:
            case 7:
            case 8:
                return "лето";
            case 9:
            case 10:
            case 11:
                return "осень";
        }
        return "осень";
    }
}
