package Lab_4;

import java.util.Arrays;

public class ArrayChecker {

    public static void main(String[] args) {
        int[] arr = new int[5];
        int summ = 0;

        try {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(args[i]);
                summ += arr[i];
            }
            if (args.length > arr.length) {
                throw new IndexOutOfBoundsException("args.length > arr.length");
            }

            System.out.println(Arrays.toString(arr));
            double avg = (double) summ /5;
            System.out.println(avg);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка индекса - "+ e.toString());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка не int - " + e.toString());
        } catch (Exception e) {
            System.out.println("Неопознанная ошибка - " + e.toString());
        } finally {
            System.out.println("End of working");
        }
    }
}
