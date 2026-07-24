package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    // Directions for traversing in 4 possible directions
    static int[] dc = {1, 0, -1, 0};
    static int[] dr = {0, 1, 0, -1};

    static class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        //int[][] grid = {{0, 1}, {1, 0}};
        int[][] grid = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };
        System.out.println(shortestBridge(grid));
    }

    /*
     * Time Complexity: O(n²)
     * - DFS visits every cell of the first island once.
     * - Multi-source BFS visits each cell of the grid at most once.
     *
     * Space Complexity: O(n²)
     * - Visited array: O(n²)
     * - BFS queue can contain up to O(n²) cells.
     * - DFS recursion stack: O(n²) in the worst case (entire grid is one island).
     */
    public static int shortestBridge(int[][] grid) {

        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<Pair> q = new LinkedList<>();

        boolean foundFirstIsland = false;

        // Step 1: Find the first island.
        // Mark all its cells as visited using DFS and
        // add them to the BFS queue.
        for (int i = 0; i < n && !foundFirstIsland; i++) {
            for (int j = 0; j < n && !foundFirstIsland; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    dfs(grid, i, j, n, visited, q);
                    foundFirstIsland = true;
                }
            }
        }

        // Step 2: Expand layer by layer from the first island.
        // The first time we reach an unvisited land cell,
        // we have reached the second island.
        return bfs(q, grid, n, visited);
    }

    // DFS to mark all cells belonging to the first island.
    // Every island cell is also added to the BFS queue,
    // making this a multi-source BFS.
    private static void dfs(int[][] grid, int r, int c, int n,
                            boolean[][] visited, Queue<Pair> q) {

        visited[r][c] = true;
        q.offer(new Pair(r, c));

        for (int k = 0; k < 4; k++) {

            int adjR = r + dr[k];
            int adjC = c + dc[k];

            if (isSafe(grid, adjR, adjC, n, visited)) {
                dfs(grid, adjR, adjC, n, visited, q);
            }
        }
    }

    // Checks whether the adjacent cell belongs to the first island
    // and has not been visited yet.
    private static boolean isSafe(int[][] grid, int r, int c,
                                  int n, boolean[][] visited) {

        return r >= 0 && r < n &&
                c >= 0 && c < n &&
                grid[r][c] == 1 &&
                !visited[r][c];
    }

    // Multi-source BFS to find the shortest bridge.
    private static int bfs(Queue<Pair> q, int[][] grid,
                           int n, boolean[][] visited) {

        int bridgeLen = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            // Process one BFS level at a time.
            while (size-- > 0) {

                Pair curr = q.poll();

                int r = curr.row;
                int c = curr.col;

                for (int k = 0; k < 4; k++) {

                    int adjR = r + dr[k];
                    int adjC = c + dc[k];

                    // Skip cells outside the grid or already visited.
                    if (adjR < 0 || adjR >= n ||
                            adjC < 0 || adjC >= n ||
                            visited[adjR][adjC]) {
                        continue;
                    }

                    // Reaching an unvisited land cell means
                    // we've found the second island.
                    if (grid[adjR][adjC] == 1) {
                        return bridgeLen;
                    }

                    // Expand only through water cells.
                    visited[adjR][adjC] = true;
                    q.offer(new Pair(adjR, adjC));
                }
            }

            // Finished expanding one layer of water.
            bridgeLen++;
        }

        return -1;
    }
}
