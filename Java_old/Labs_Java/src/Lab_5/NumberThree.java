package Lab_5;


import java.util.regex.*;

public class NumberThree {
    public static void main(String[] args){
        String text = "fdAAb";
        try {
            System.out.println(FindCombination(text));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String FindCombination(String text) throws Exception{
        Pattern pattern = Pattern.compile("([a-z])([A-Z])");
        Matcher matcher = pattern.matcher(text);
        String result = matcher.replaceAll("!$1$2!");
        return result;
    }
}
