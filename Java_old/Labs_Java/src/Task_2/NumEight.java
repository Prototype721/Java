package Task_2;

import java.util.Scanner;

public class NumEight {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] rows = input.substring(2, input.length()-2).split("\\],\\[");
        int[][] matrix = new int[rows.length][];
        for(int i = 0; i < rows.length; i++){
            String[] elements = rows[i].split(",");
            matrix[i] = new int[elements.length];
            for(int j = 0; j < elements.length; j++){
                matrix[i][j] = Integer.parseInt(elements[j]);
            }
        }
        System.out.println(diagonalSum(matrix));
    }

    public static int diagonalSum(int[][] matrix){
        int sum = 0;
        for(int i = 0; i < matrix.length; i++){
            sum += matrix[i][i];
        }
        return sum;
    }
}