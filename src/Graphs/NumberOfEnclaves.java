package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally)
land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the
boundary of the grid in any number of moves.

Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.

Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.
 */
public class NumberOfEnclaves {

    class Node{
        int x;
        int y;

        Node(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        NumberOfEnclaves obj = new NumberOfEnclaves();
        System.out.println(obj.numEnclaves(grid));
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<Node> queue = new LinkedList<>();
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if((i == 0 || j == 0 || i == m-1 || j == n-1) && grid[i][j] == 1)
                {
                    queue.add(new Node(i,j));
                    visited[i][j] = true;
                }
            }
        }

        int[] row = {1, 0, -1, 0};
        int[] col = {0, 1, 0, -1};
        while(!queue.isEmpty())
        {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;

            for(int k = 0; k<4; k++)
            {
                int nrow = x + row[k];
                int ncol = y + col[k];

                if(nrow>=0 && nrow < m && ncol >= 0 && ncol<n
                        && !visited[nrow][ncol] && grid[nrow][ncol] == 1)
                {
                    visited[nrow][ncol] = true;
                    queue.offer(new Node(nrow, ncol));
                }
            }
        }

        int count = 0;
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(grid[i][j] == 1 && visited[i][j] == false) count++;
            }
        }
        return count;
    }
}

/*
Time complexity: O(m⋅n)

Initializing the visit array takes O(m⋅n) time.
We iterate over the boundary of grid and find unvisited land cells to perform BFS traversal from those.
This takes O(m+n) time.
Each queue operation in the BFS algorithm takes O(1) time and a single node can be pushed
at most once in the queue. Since there are O(m⋅n) nodes, we will perform O(m⋅n) operations
visiting all nodes in the worst-case scenario. We iterate over all the neighbors of each node
 that is popped out of the queue. So for every node, we would iterate four times over the neighbors,
 resulting in O(4⋅m⋅n)=O(m⋅n) operations total for all the nodes.
Space complexity: O(m⋅n)

The visit array takes O(m⋅n) space.
 */
