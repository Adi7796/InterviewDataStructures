package Graphs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary grid[][], where each cell contains either 0 or 1, find the distance of the nearest 1
for every cell in the grid.
The distance between two cells (i1, j1)  and (i2, j2) is calculated as |i1 - i2| + |j1 - j2|.
You need to return a matrix of the same size, where each cell (i, j) contains the minimum distance from grid[i][j]
to the nearest cell having value 1.

Note: It is guaranteed that there is at least one cell with value 1 in the grid.

Examples

Input: grid[][] = [[0, 1, 1, 0],
                [1, 1, 0, 0],
                [0, 0, 1, 1]]
Output: [[1, 0, 0, 1],
        [0, 0, 1, 1],
        [1, 1, 0, 0]]


Input: grid[][] = [[1, 0, 1],
                [1, 1, 0],
                [1, 0, 0]]
Output: [[0, 1, 0],
        [0, 0, 1],
        [0, 1, 2]]
 */
public class DistanceOfNearestOnes {

    static class Node{
        int row;
        int col;
        int dist;

        public Node(int row, int col, int dist)
        {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 1},
                        {1, 1, 0},
                        {1, 0, 0}};
        ArrayList<ArrayList<Integer>> ansGrid = nearest(grid);
        for(int i=0; i<grid.length; i++)
        {
            System.out.print("[ ");
            for(int j=0; j<grid[0].length; j++)
            {
                System.out.print(ansGrid.get(i).get(j) + " ");
            }
            System.out.print("]");
            System.out.println();
        }

    }

    public static ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        int m = grid.length;
        int n = grid[0].length;

        int[][] distGrid = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                distGrid[i][j] = Integer.MAX_VALUE;
                visited[i][j] = false;
            }
        }

        generateGrid(grid, distGrid, visited, m, n);
        ArrayList<ArrayList<Integer>> distGridList = new ArrayList<>();
        for(int i=0; i<m; i++)
        {
            distGridList.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                distGridList.get(i).add(distGrid[i][j]);
            }
        }

        return distGridList;
    }


    private static int[][] generateGrid(int[][] grid, int[][] distGrid, boolean[][] visited, int m, int n)
    {
        Queue<Node> queue = new LinkedList<>();
        int[] COL = {1, 0, -1, 0};
        int[] ROW = {0, 1, 0, -1};

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 1){
                    queue.add(new Node(i, j, 0));
                }
            }
        }


        while(!queue.isEmpty())
        {
            Node currNode = queue.poll();
            distGrid[currNode.row][currNode.col] = Math.min(currNode.dist, distGrid[currNode.row][currNode.col]);
            int row = currNode.row;
            int col = currNode.col;
            int dist = currNode.dist;


            for(int k=0; k<4; k++)
            {
                if(isSafe(grid, visited, row + ROW[k], col + COL[k], m, n))
                {
                    int newRow = row + ROW[k];
                    int newCol = col + COL[k];
                    visited[newRow][newCol] = true;
                    queue.add(new Node(newRow, newCol, dist+1));
                }
            }
        }

        return distGrid;
    }

    private static boolean isSafe(int[][] grid, boolean[][] visited, int r, int c, int m, int n)
    {
        return (r>=0 && r<m) &&
                (c>=0 && c<n) &&
                !visited[r][c] && grid[r][c] == 0;
    }


}
