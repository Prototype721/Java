package Task_3;

import java.util.LinkedList;
import java.util.Scanner;

public class NumSix {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        line = line.substring(1, line.length()-1);
        String[] arrStr = line.split(", ");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++){
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        int[] answer = filterEven(arr);

        System.out.print("[");
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]);
            if (i < answer.length-1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static int[] filterEven(int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : arr) {
            if (num % 2 == 0) {
                list.addLast(num);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
