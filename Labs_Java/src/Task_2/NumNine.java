package Task_2;

import java.util.*;

public class NumNine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int firstBracket = input.indexOf('[');
        int secondBracket = input.indexOf(']');
        int thirdBracket = input.indexOf('[', secondBracket);
        int fourthBracket = input.indexOf(']', thirdBracket);

        String aContent = input.substring(firstBracket + 1, secondBracket);
        String bContent = input.substring(thirdBracket + 1, fourthBracket);

        int[] a = parseArray(aContent);
        int[] b = parseArray(bContent);

        int[] result = mergeUniqueSorted(a, b);

        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }

    public static int[] mergeUniqueSorted(int[] a, int[] b) {
        Set<Integer> set = new TreeSet<>();
        for (int num : a) set.add(num);
        for (int num : b) set.add(num);

        int[] result = new int[set.size()];
        int i = 0;
        for (int num : set) {
            result[i] = num;
            i++;
        }
        return result;
    }

    public static int[] parseArray(String content) {
        if (content.isEmpty()) return new int[0];

        String[] parts = content.split(",");
        List<Integer> nums = new ArrayList<>();

        for (String part : parts) {
            nums.add(Integer.parseInt(part));
        }

        int[] arr = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) arr[i] = nums.get(i);
        return arr;
    }
}
