package Lab_7;
// Var 2

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;


public class ArraySum {
    public static void main(String[] args) throws Exception {
        final int ARRAY_SIZE = 100_000_000;

        long[] myarr = new long[ARRAY_SIZE];

        for (int i = 0; i < ARRAY_SIZE; i++) {
            myarr[i] = (long) i * i;
        }

        Callable<Long> task1 = createTask(myarr, 1, ARRAY_SIZE);
        Callable<Long> task2 = createTask(myarr, 2, ARRAY_SIZE);
        Callable<Long> task3 = createTask(myarr, 3, ARRAY_SIZE);
        Callable<Long> task4 = createTask(myarr, 4, ARRAY_SIZE);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        Future<Long> maxFirst = executor.submit(task1);
        Future<Long> maxSecond = executor.submit(task2);
        Future<Long> maxThird = executor.submit(task3);
        Future<Long> maxFourth = executor.submit(task4);

        long max1 = maxFirst.get();
        long max2 = maxSecond.get();
        long max3 = maxThird.get();
        long max4 = maxFourth.get();

        long overallMax = Math.max(Math.max(max1, max2), Math.max(max3, max4));

        System.out.println("Maximum threaded: " + overallMax);

        executor.shutdown();

    }

    private static Callable<Long> createTask(long[] array, int part, int arraySize) {
        return () -> {
            int start, end;

            switch (part) {
                case 1:
                    start = 0;
                    end = arraySize / 4;
                    break;
                case 2:
                    start = arraySize / 4;
                    end = arraySize / 2;
                    break;
                case 3:
                    start = arraySize / 2;
                    end = arraySize * 3 / 4;
                    break;
                default:
                    start = arraySize * 3 / 4;
                    end = arraySize;
                    break;
            }

            long maxi = 0;
            for (int i = start; i < end; i++) {
                if (maxi < array[i]) maxi = array[i];
            }

            System.out.println("Part " + part + " max: " + maxi + " (range: " + start + "-" + (end-1) + ")");
            return maxi;
        };
    }
}


