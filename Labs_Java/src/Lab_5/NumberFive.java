package Lab_5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFive {
    public static void main(String[] args){
        String text = "Ayo everyone. Am i the best Progger-Assembler - Absolute";
        String letter = "A";
        try {
            FindAlpha(text, letter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void FindAlpha(String text, String letter) throws Exception{
        String regexpression = "\\b" + letter + "\\w*\\b";
        Pattern pattern = Pattern.compile(regexpression);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
