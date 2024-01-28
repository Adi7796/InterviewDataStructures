package Matrices;

public class RotateMatrix {
    static int  N = 4;
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4},
                       {5, 6, 7, 8},
                       {9, 10, 11, 12},
                       {13, 14, 15, 16}};

        int[][] mat2 = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        transpose(mat);
        transpose(mat2);
        rotateClockWise(mat);
        rotateAntiClockWise(mat2);
        System.out.println("Matrix rotated ClockWise :- ");
        display(mat);
        System.out.println("Matrix rotated AntiClockWise :- ");
        display(mat2);
    }

    public static void transpose(int[][] mat)
    {
        for(int i=0; i<N; i++)
        {
            for(int j=i; j<N; j++)
            {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    public static void rotateClockWise(int[][] mat)
    {
        for(int i=0; i<N; i++)
        {
            int leftIndex = 0;
            int rightIndex = N-1;
            while(leftIndex < rightIndex)
            {
                int temp = mat[i][leftIndex];
                mat[i][leftIndex] = mat[i][rightIndex];
                mat[i][rightIndex] = temp;

                leftIndex ++;
                rightIndex --;
            }
        }
    }

    public static void rotateAntiClockWise(int[][] mat)
    {
        for(int i=0; i<N; i++)
        {
            int topIndex = 0;
            int bottomIndex = N-1;
            while(topIndex < bottomIndex)
            {
                int temp = mat[topIndex][i];
                mat[topIndex][i] = mat[bottomIndex][i];
                mat[bottomIndex][i] = temp;

                topIndex ++;
                bottomIndex --;
            }
        }
    }

    public static void display(int[][] mat)
    {
        for(int i=0; i<N; i++)
        {
            for(int j=0;j<N; j++)
            {
                System.out.print(mat[i][j] +  " ");
            }
            System.out.println();
        }
    }
}
