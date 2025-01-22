package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two cells sharing a common edge is 1.
 */
public class ZeroOneMatrix {

    class Node
    {
        int x,y,steps;
        Node(int x, int y, int steps)
        {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", steps=" + steps +
                    '}';
        }
    }
    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};

    }

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] dist = new int[m][n];
        Queue<Node> queue = new LinkedList<>();

        // visit all the nodes with 0 as a value
        // we'll start our bfs with these 0's
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j < n ; j++)
            {
                if(mat[i][j] == 0)
                {
                    visited[i][j] = true;
                    queue.add(new Node(i, j, 0));
                }
            }
        }

        int[] ROW = {1, 0, -1, 0};
        int[] COL = {0, 1, 0, -1};

        while(!queue.isEmpty())
        {
            Node node = queue.remove();
            int x = node.x;
            int y = node.y;
            int steps = node.steps;

            // update the dist matrix with the dist from the nearest 0 cell
            dist[x][y] = steps;

            for(int k = 0; k < 4 ; k++)
            {
                int newRow = x + ROW[k];
                int newCol = y + COL[k];
                // check if we can visit a cell with 1 value from our current 0 cell
                if(isValid(m, n, newRow, newCol, mat, visited))
                {
                    // visit the 1 cell
                    visited[newRow][newCol] = true;
                    queue.add(new Node(newRow, newCol, steps+1));
                }
            }
        }

        return dist;
    }

    public boolean isValid(int m, int n, int row, int col, int[][] mat, boolean[][] visited)
    {
        if(row < m && row >=0 && col < n && col >= 0 && mat[row][col] == 1 && !visited[row][col])
            return true;
        return false;
    }
}

/*
Time Complexity: O(NxM + NxMx4) ~ O(N x M)

For the worst case, the BFS function will be called for (N x M) nodes,
and for every node, we are traversing for 4 neighbors, so it will take O(N x M x 4) time.

Space Complexity: O(N x M) + O(N x M) + O(N x M) ~ O(N x M)

O(N x M) for the visited array, distance matrix, and queue space takes up N x M locations at max.
 */
