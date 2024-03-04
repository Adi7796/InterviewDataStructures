package Backtracking;

import java.util.Arrays;

/*
Given a N*N board with the Knight placed on the first block of an empty board.
Moving according to the rules of chess knight must visit each square exactly once.
Print the order of each cell in which they are visited.
 */
public class KnightsTour {

    static int N=8;
    static int move = 1;
    public static void main(String[] args) {
        int[][] mat = new int[N][N];
        for(int i=0;i<N; i++)
        {
            for(int j=0;j<N;j++)
            {
                mat[i][j] = -1;
            }
        }

        knightTour(mat, 0, 0, 1);
    }

    public static void knightTour(int[][] mat, int row, int col, int move)
    {
        if(row<0 || col < 0 || row >=N || col >=N || mat[row][col] != -1)
            return;

        if(move == N*N) {
            mat[row][col] = move;
            displayBoard(mat);
            //mat[row][col] = -1;
            return;
        }
        mat[row][col] = move;

        int[] rowDir = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] colDir =  {1, 2, 2, 1, -1, -2, -2, -1};

        for(int k=0;k<8;k++)
        {
            knightTour(mat, row + rowDir[k], col + colDir[k], move+1);
        }

        mat[row][col] = -1;
    }

    public static void displayBoard(int[][] mat)
    {
        System.out.println("Display Board : ");
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*
Time Complexity :
There are N2 Cells and for each, we have a maximum of 8 possible moves to choose from,
so the worst running time is O(8N^2).

Auxiliary Space: O(N2)
 */
