package Lab_4;


import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class CustomException {

    public static void logException(String message) {
        try  {
            Path path = Paths.get("exceptions.txt");
            Files.write(path, message.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        } catch (IOException ioEx) {
            System.out.println("Ошибка при записи в лог: " + ioEx.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int number = scanner.nextInt();
            System.out.println("Число: " + number);
        } catch (InputMismatchException e) {
            CustomInputMismatchException customException = new CustomInputMismatchException("Ошибка: введено нецелое число!");
            logException("Исключение " + e.toString() + "\n");
            System.out.println(customException.getMessage());
        } catch (Exception e) {
            logException("Исключение " + e.toString() + "\n");
            System.out.println("Неопознанная ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
