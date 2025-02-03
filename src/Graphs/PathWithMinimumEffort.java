package Graphs;

import java.util.PriorityQueue;

/*
You are a hiker preparing for an upcoming hike.
You are given heights, a 2D array of size rows x columns, where heights[row][col]
represents the height of cell (row, col). You are situated in the top-left cell, (0, 0),
and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference
in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.

heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].

heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: This route does not require any effort.
 */
public class PathWithMinimumEffort {
    class Node implements Comparable<Node>{
        int x;
        int y;
        int diff;

        Node(int x, int y, int diff)
        {
            this.x = x;
            this.y = y;
            this.diff = diff;
        }

        public int compareTo(Node node)
        {
            return this.diff - node.diff;
        }
    }
    public int minimumEffortPath(int[][] heights)
    {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];

        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 0;
        pq.add(new Node(0,0,0));

        while(!pq.isEmpty())
        {
            Node node = pq.remove();
            int row = node.x;
            int col = node.y;
            int diff = node.diff;

            if(row == m-1 && col == n-1) return diff;

            int[] Row ={1, 0, -1, 0};
            int[] Col = {0, 1, 0, -1};

            for(int k = 0; k<4; k++)
            {
                int nRow = row + Row[k];
                int nCol = col + Col[k];

                if(nRow >=0 && nRow < m && nCol >=0 && nCol < n)
                {
                    int effort = Math.max(Math.abs(heights[row][col] - heights[nRow][nCol]), diff);

                    if(dist[nRow][nCol] > effort)
                    {
                        dist[nRow][nCol] = effort;
                        pq.add(new Node(nRow, nCol, effort));
                    }
                }
            }
        }
        return 0;
    }
}

/*
Time Complexity : O(m⋅nlog(m⋅n))
 */
