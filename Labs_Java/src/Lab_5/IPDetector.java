package Lab_5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPDetector {
    public static void main(String[] args){
        String text = "0.0.0.0";
        try {
            if(FindIP(text)){
                System.out.println("IP");
            }
            else{
                System.out.println("Не IP");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    } // (([0-9])|([1-9][0-9])|(1[0-9][0-9])|(2([0-4][0-9]|5[0-5])))
    // "^((chislo)\\.){3}(chislo)$"
    public static boolean FindIP(String text) throws Exception{
        Pattern pattern = Pattern.compile("^(((\\d)|([1-9]\\d)|(1\\d{2})|(2([0-4]\\d|5[0-5])))\\.){3}((\\d)|([1-9]\\d)|(1\\d{2})|(2([0-4]\\d|5[0-5])))$");
        Matcher matcher = pattern.matcher(text);

        return matcher.find();
    }
}
