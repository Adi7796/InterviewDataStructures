package Matrices;

public class ZigZagTraversal {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        printZigZagTraversal(mat);
    }

    public static void printZigZagTraversal(int[][] mat)
    {
        int minRow = 0;
        int minCol = 0;
        int maxRow = mat.length-1;
        int maxCol = mat[0].length-1;
        int totalElements = (mat.length) * (mat[0].length);
        int count =0;
        while(count < totalElements)
        {
            // left wall --> we fix the leftmost col and increase the row count from minrow to max row
            for(int i=minRow, j=minCol; i<=maxRow && count <= totalElements; i++)
            {
                System.out.println(mat[i][j]);
                count++;
            }
            minCol++;  // we increment the maxcol as for bottom wall we have already printed the first element of bottom wall while printing the left wall

            //bottom wall --> we fix the maxrow and increment the column from mincol to maxcol
            for(int i=maxRow, j=minCol; j<=maxCol && count <= totalElements; j++)
            {
                System.out.println(mat[i][j]);
                count++;
            }
            maxRow--;

            // right wall  --> we fix the maxCol and decrement the row from maxrow to minrow
            for(int i=maxRow, j=maxCol; i>=minRow && count <= totalElements; i--)
            {
                System.out.println(mat[i][j]);
                count++;
            }
            maxCol--;

            // top wall --> we fix the minrow and decrement the col from maxcol to mincol
            for(int i=minRow, j=maxCol; j>=minCol && count <= totalElements; j--)
            {
                System.out.println(mat[i][j]);
                count++;
            }
            minRow++;
        }
    }
}
