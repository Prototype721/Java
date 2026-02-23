package Task_3;

import java.util.Arrays;
import java.util.Scanner;

public class NumFive {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(", ");
        System.out.println(isAnagram(line[0], line[1]));
    }

    public static boolean isAnagram(String text1, String text2){
        char[] word1 =  text1.toCharArray();
        char[] word2 =  text2.toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);
        if (Arrays.equals(word1, word2)){
            return true;
        }
        return false;
    }
}
