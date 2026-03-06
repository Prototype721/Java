package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("Программа запущена");

        printBuildPassport();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку:");

        String input = scanner.nextLine();

        String reversed = StringProcessor.reverse(input);
        String capitalized = StringProcessor.capitalize(input);

        logger.info("Reverse: {}", reversed);
        logger.info("Capitalized: {}", capitalized);

        logger.info("Программа завершена");
    }

    private static void printBuildPassport() {

        try {

            Properties props = new Properties();

            InputStream myInputStream =
                    Main.class.getClassLoader()
                            .getResourceAsStream("build-passport.properties");

            if (myInputStream != null) {

                props.load(myInputStream);

                System.out.println("---------BUILD PASSPORT--------");

                props.forEach((k, v) ->
                        System.out.println(k + ": " + v));

                System.out.println("-------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}