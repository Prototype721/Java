package Lab_5;

import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args){
        try {
            String text = "Hi    a12 1 2.2 -3 -44.44    5.6.7    8..9    .0.";
            Pattern pattern = Pattern.compile("(?<![\\w._])-?\\d+(\\.\\d+)?(?![\\w.-_])");

            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                String group = matcher.group();
                //if (!group.equals("")){
                System.out.println(matcher.group());
                //}
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
