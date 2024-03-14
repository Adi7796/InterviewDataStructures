package Matrices;

public class SpiralMatrix {
    public static void main(String[] args) {
        int n = 5;
        int[][] matrix = generateMatrix(n);

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int totalElements = n*n;

        int maxRow = n-1;
        int maxCol = n-1;
        int minRow = 0;
        int minCol = 0;

        int count = 1;

        while(count < totalElements)
        {
            for(int j=minCol; j<=maxCol; j++)
            {
                matrix[minRow][j] = count;
                count++;
            }

            minRow++;

            for(int i=minRow; i<=maxRow; i++)
            {
                matrix[i][maxCol] = count;
                count++;
            }
            maxCol--;

            for(int j=maxCol;j>=minCol;j--)
            {
                matrix[maxRow][j] = count;
                count++;
            }
            maxRow--;

            for(int i=maxRow;i>=minRow;i--)
            {
                matrix[i][minCol] = count;
                count++;
            }

            minCol++;
        }
        if(n%2==1) matrix[maxRow][minCol] = count;
        return matrix;
    }
}
