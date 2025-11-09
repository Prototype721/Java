package Task_3;

import java.util.Scanner;

public class NumTwo {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(countVowels(line));
    }
    public static int countVowels(String line){
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char c : line.toCharArray()){
            if (vowels.indexOf(c) != -1){
                count++;
            }
        }
        return count;
    }

}
