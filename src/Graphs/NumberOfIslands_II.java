package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are given an empty 2D binary grid grid of size m x n.
The grid represents a map where 0's represent water and 1's represent land.
Initially, all the cells of grid are water cells (i.e., all the cells are 0's).

We may perform an add land operation which turns the water
at position into a land. You are given an array positions where
positions[i] = [ri, ci] is the position (ri, ci) at which we should operate the ith operation.

Return an array of integers answer where answer[i] is the number
of islands after turning the cell (ri, ci) into a land.

An island is surrounded by water and is formed by connecting adjacent
lands horizontally or vertically. You may assume all four edges of the grid are all
surrounded by water.

Input: m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]
Output: [1,1,2,3]
Explanation:
Initially, the 2d grid is filled with water.
- Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land. We have 1 island.
- Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land. We still have 1 island.
- Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land. We have 2 islands.
- Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land. We have 3 islands.
 */
public class NumberOfIslands_II {

    int[] parent;
    int[] rank;

    public static void main(String[] args) {
       int m = 3, n = 3;
       int[][] positions = {{0,0},{0,1},{1,2},{2,1}};

       NumberOfIslands_II obj = new NumberOfIslands_II();
       obj.numIslands2(n, m, positions).stream().forEach(System.out::println);
    }
    public List<Integer> numIslands2(int n, int m, int[][] positions)
    {
        List<Integer> ansList = new ArrayList<>();
        int[][] visited = new int[n][m];
        parent = new int[n*m];
        rank = new int[n*m];

        for(int i = 0; i<n*m; i++)
        {
            parent[i] = i;
            rank[i] = 0;
        }

        for(int[] row : visited)
        {
            Arrays.fill(row, 0);
        }

        int count = 0;
        for(int i = 0; i < positions.length; i++)
        {
            int row = positions[i][0];
            int col = positions[i][1];
            if(visited[row][col] == 1)
            {
                ansList.add(count);
                continue;
            }

            visited[row][col] = 1;
            count++;
            // row -1, col
            // row, col+1
            // row, col-1
            // row+1, col

            int[] dr = {-1, 0, 0, 1};
            int[] dc = {0, 1, -1, 0};

            for(int k = 0; k < 4; k++)
            {
                int adjr = row + dr[k];
                int adjc = col + dc[k];

                if(isValid(adjr, adjc, n, m))
                {
                    if(visited[adjr][adjc] == 1)
                    {
                        int currNode = (row * m) + col;
                        int adjNode = (adjr * m) + adjc;
                        if(findParent(currNode) != findParent(adjNode))
                        {
                            count--;
                            unionByRank(currNode, adjNode);
                        }
                    }
                }
            }
            ansList.add(count);
        }
        return ansList;
    }

    private void unionByRank(int u, int v)
    {
        int parent_u = findParent(u);
        int parent_v = findParent(v);

        if(rank[parent_v] > rank[parent_u])
        {
            parent[parent_u] = parent_v;
        }
        else if(rank[parent_v] < rank[parent_u])
        {
            parent[parent_v] = parent_u;
        }
        else
        {
            parent[parent_v] = parent_u;
            rank[parent_u]++;
        }
    }

    private int findParent(int u)
    {
        if(parent[u] == u)
        {
            return u;
        }
        return parent[u] = findParent(parent[u]);
    }

    private boolean isValid(int row, int col, int n, int m)
    {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}
