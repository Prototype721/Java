package Task_2;

import java.util.Scanner;

public class NumTen {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        System.out.println(grade(score));
    }

    public static String grade(int score){
        if(score < 0 || score > 100) return "Invalid";
        if(score >= 90) return "A";
        if(score >= 80) return "B";
        if(score >= 70) return "C";
        if(score >= 60) return "D";
        return "F";
    }
}