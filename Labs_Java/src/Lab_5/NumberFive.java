package Lab_5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFive {
    public static void main(String[] args){
        String text = "Ayo everyone. Am I the best Progger-Assembler - absolute";
        String letter = "A";
        try {
            FindAlpha(text, letter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void FindAlpha(String text, String letter) throws Exception{
        String regexpression = "\\b[" + letter.toLowerCase() + letter.toUpperCase() + "]\\w*\\b";
        Pattern pattern = Pattern.compile(regexpression);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
