package Lab_7;

public class MatrixCalc extends Thread{

    public int[][] matrixInside;

    public long maxi;
    public int row_num;

    public MatrixCalc(int row, int[][] matrix) {
        this.row_num = row;
        this.matrixInside = matrix;
    }

    @Override
    public void run(){
        for(int elem : matrixInside[row_num]){
            if(elem > maxi) maxi = elem;
        }
    }


    public static void main(String[] args) throws InterruptedException{
        final int ROW_SIZE = 1_000_000;

        int[][] matrix = new int[3][ROW_SIZE];
        for (int i = 0; i < ROW_SIZE; i++){
            matrix[0][i] = i;
            matrix[1][i] = i*i;
            matrix[2][i] = i*i*i;
        }


        MatrixCalc calc1 = new MatrixCalc(0, matrix);
        MatrixCalc calc2 = new MatrixCalc(1, matrix);
        MatrixCalc calc3 = new MatrixCalc(2, matrix);


        calc1.start();
        calc2.start();
        calc3.start();

        calc1.join();
        calc2.join();
        calc3.join();

        long overallMax = Math.max(Math.max(calc1.maxi, calc2.maxi), calc3.maxi);
        System.out.println("Max: " + overallMax);
    }
}
