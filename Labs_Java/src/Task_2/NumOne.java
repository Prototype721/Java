package Task_2;


import java.util.Scanner;

public class NumOne {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(countDivisors(num));

    }

    public static int countDivisors(int num){
        int count = 0;
        for(int i=1; i<=num; i++){
            if (num%i == 0){
                count++;
            }

        }
        return count;
    }

}
