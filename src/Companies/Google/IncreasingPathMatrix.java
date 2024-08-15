package Companies.Google;

import java.util.ArrayList;

public class IncreasingPathMatrix {
    static ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
    static ArrayList<Integer> subList = new ArrayList<>();

    static int maxIndex = 0;
    static int maxLength = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int mat[][] = {
                { 9, 9, 4 },
                { 6, 6, 8 },
                { 2, 1, 1 }};

        int n = mat.length, m = mat[0].length;
        boolean[][] isVisited = new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                isVisited[i][j] = false;
            }
        }

        for(int i=0;i<n; i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!isVisited[i][j]){
                    findLongestPath(mat, isVisited, i, j, n, m);
                }

            }
        }

        System.out.println("All Increasing Paths : ");
        for(ArrayList<Integer> i : ansList)
            System.out.println(i + " ");

        System.out.println("Max Increasing Path : " + ansList.get(maxIndex));
    }

    static void findLongestPath(int[][] mat, boolean[][] isVisited,int row, int col, int n, int m){

        isVisited[row][col] = true;
        subList.add(mat[row][col]);
        int[] rowDir = {1, 0, -1, 0};
        int[] colDir = {0, 1, 0, -1};

        for(int k=0;k<4;k++)
        {
            if(isValid(mat, isVisited, row, row + rowDir[k], col, col + colDir[k], n, m))
            {
               findLongestPath(mat, isVisited, row + rowDir[k], col + colDir[k], n, m);
            }
        }

        if(subList.size()>maxLength){
            maxLength = subList.size();
            maxIndex = ansList.size();
        }
        if(subList.size()>=2) ansList.add(new ArrayList<>(subList));
        subList.remove(subList.size()-1);
        isVisited[row][col] = false;
    }

    static boolean isValid(int[][] mat, boolean[][] isVisited, int prevRow, int row, int prevCol, int col, int n, int m)
    {
        return row>=0 && row<n
                && col>=0 && col<m
                && !isVisited[row][col]
                && mat[prevRow][prevCol] < mat[row][col];
    }
}
