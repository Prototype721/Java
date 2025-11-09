package Lab_5;

import java.util.regex.*;

public class PasswodValidation {

    public static void main(String[] args) {
        try {
            String password = "1234A-56789";
            Check_password(password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void Check_password(String password) throws Exception {
        if (password.isEmpty()) {
            throw new Exception("Пустой пароль");
        }

        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d).[^\\s]{8,16}$");
        Matcher matcher = pattern.matcher(password);

        if (matcher.find()) {
            System.out.println("Подходит");
        } else {
            System.out.println("Не подходит");
        }
    }
}
