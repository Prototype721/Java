package Task_3;

import java.util.Scanner;

public class NumSeven {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(countWords(line));
    }
    public static int countWords(String line){
        String[] words = line.strip().split("\\s+");
        return words.length;
    }

}
