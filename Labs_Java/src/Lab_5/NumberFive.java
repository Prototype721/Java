package Lab_5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFive {
    public static void main(String[] args){
        String text = "Hello everyone. I am best Progger-Misha - Absolute";
        try {
            FindAlpha(text);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void FindAlpha(String text) throws Exception{
        Pattern pattern = Pattern.compile("\\b[A-Z]\\w*\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
