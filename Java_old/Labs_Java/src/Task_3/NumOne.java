package Task_3;

import java.util.Scanner;

public class NumOne {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(reverseWords(line));
    }
    public static String reverseWords(String line){
        String[] words = line.split(" ");
        if (words.length == 0){
            return "";
        }
        StringBuilder rwordsCombined = new StringBuilder();
        for (int i = words.length-1; i > 0; i--) {
            rwordsCombined.append(words[i] + " ");
        }
        rwordsCombined.append(words[0]);
        return  rwordsCombined.toString();
    }

}
