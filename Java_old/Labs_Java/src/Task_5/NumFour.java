package Task_5;



import java.util.*;

public class NumFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = Long.parseLong(scanner.nextLine());
        scanner.close();
        System.out.println(turns(number));
    }

    public static int turns(long number) {
        if (number < 10)
            return 0;

        String numStr = Long.toString(number);
        int turns = 0;
        int prevDir = 0;

        for (int i = 1; i < numStr.length(); i++) {
            int prev = numStr.charAt(i - 1) - '0';
            int curr = numStr.charAt(i) - '0';

            if (curr > prev) {
                if (prevDir == -1)
                    turns++;
                prevDir = 1;
            } else if (curr < prev) {
                if (prevDir == 1)
                    turns++;
                prevDir = -1;
            }
        }
        return turns;
    }
}