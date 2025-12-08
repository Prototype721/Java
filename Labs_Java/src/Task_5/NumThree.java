package Task_5;


import java.util.*;

public class NumThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        List<Object> nestedList = parseNestedList(input);
        List<Integer> result = deepFlatten(nestedList);
        System.out.println(result);
    }

    public static List<Integer> deepFlatten(List<Object> list) {
        List<Integer> result = new ArrayList<>();
        flattenRecursive(list, result);
        return result;
    }

    private static void flattenRecursive(Object obj, List<Integer> result) {
        if (obj instanceof Integer) {
            result.add((Integer) obj);
        } else if (obj instanceof List) {
            List<?> sublist = (List<?>) obj;
            for (Object item : sublist) {
                flattenRecursive(item, result);
            }
        }
    }

    private static List<Object> parseNestedList(String input) {
        input = input.trim();
        if (input.startsWith("[") && input.endsWith("]")) {
            input = input.substring(1, input.length() - 1);
        }

        List<Object> result = new ArrayList<>();
        int i = 0;
        int length = input.length();

        while (i < length) {
            char c = input.charAt(i);

            if (c == ' ') {
                i++;
            } else if (c == '[') {
                int bracketCount = 1;
                int start = i;
                i++;

                while (i < length && bracketCount > 0) {
                    if (input.charAt(i) == '[')
                        bracketCount++;
                    if (input.charAt(i) == ']')
                        bracketCount--;
                    i++;
                }

                String inner = input.substring(start, i);
                result.add(parseNestedList(inner));

                if (i < length && input.charAt(i) == ',')
                    i++;

            } else if (Character.isDigit(c) || c == '-') {
                int start = i;
                while (i < length && (Character.isDigit(input.charAt(i)) ||
                        input.charAt(i) == '-')) {
                    i++;
                }

                String numStr = input.substring(start, i);
                try {
                    result.add(Integer.parseInt(numStr));
                } catch (NumberFormatException e) {
                }

                if (i < length && input.charAt(i) == ',')
                    i++;

            } else if (c == ',') {
                i++;
            } else {
                i++;
            }
        }
        return result;
    }
}