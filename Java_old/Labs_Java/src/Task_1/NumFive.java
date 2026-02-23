package Task_1;

import java.util.Scanner;

public class NumFive {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.print(daysToWeeks(num));
    }

    public static String daysToWeeks(int num){
        int weeks = num/7;
        int days = num%7;
        String weeks_word = "недель";
        String days_word = "дней";

        if (weeks == 1){
            weeks_word = "неделя";
        }
        if ((weeks == 2) || (weeks == 3) || (weeks == 4)){
            weeks_word = "недели";
        }
        if (days == 1){
            days_word = "день";
        }
        if ((days == 2) || (days == 3) || (days == 4)) {
            days_word = "дня";
        }
        return weeks + " " + weeks_word + " и " + days + " " + days_word;
    }
}