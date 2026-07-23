package Graphs.DisjointSet;

import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland {
    static int[] parent;
    static int[] size;
    static int[] dc = {1, 0, -1, 0};
    static int[] dr = {0, 1, 0, -1};

    public static void main(String[] args) {
        //int[][] mat = {{1,1},{1,1}};
        int[][] mat = {{1,0},{0,1}};
        System.out.println(largestIsland(mat));
    }

    public static int largestIsland(int[][] grid) {
        // code here
        int n = grid.length;
        int m = grid[0].length;

        parent = new int[n*m];
        size = new int[n*m];

        for(int i=0; i<n*m; i++)
        {
            parent[i] = i;
            size[i] = 1;
        }

        createDisjointSet(grid, n, m);
        return getSize(grid, n, m);
    }

    private static void createDisjointSet(int[][] grid, int n, int m)
    {
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j] == 1)
                {
                    for(int k=0; k<4; k++)
                    {
                        int adjR = i + dr[k];
                        int adjC = j + dc[k];
                        if(isValid(adjR, adjC, n, m, grid))
                        {
                            int u = (i*m) + j;
                            int v = (adjR*m) + adjC;
                            if(find(u) != find(v))
                            {
                                unionBySize(u, v);
                            }
                        }
                    }
                }
            }
        }
    }

    private static int getSize(int[][] grid, int n, int m)
    {
        int maxSize = Integer.MIN_VALUE;
        boolean zeroFlipped = false; // this is to check if we have flipped any zero for a corner case of all 1's in the grid
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j] == 0)
                {
                    zeroFlipped = true;
                    Set<Integer> parentSet = new HashSet<>();
                    for(int k=0; k<4; k++)
                    {
                        int adjR = i + dr[k];
                        int adjC = j + dc[k];

                        if(isValid(adjR, adjC, n, m, grid))
                        {
                            int u = (adjR*m) + adjC;
                            int parent = find(u);
                            // we use a set so that we calculate the size of only unique parents
                            // suppose a left and right cell both have 1 and belong to the same disjoint set,
                            // we'll end up adding the size[parent] of both these cells
                            // hence we need to add the parent to the set
                            parentSet.add(parent);
                        }
                    }
                    maxSize = Math.max(maxSize, calculateSize(parentSet));
                }
            }
        }

        if(!zeroFlipped) return size[0];  // in case we haven't flipped any zero's that means all 1's are now connected to the first grid element 0
        return maxSize;
    }

    // helper function to calculate the size of all parent nodes in the set
    private static int calculateSize(Set<Integer> parentSet)
    {
        int islandSize = 0;
        for(int parent : parentSet)
        {
            islandSize += size[parent];
        }

        return islandSize + 1;  // we add 1 for the 0 that we flipped to 1
    }

    private static boolean isValid(int r, int c, int n, int m, int[][] grid)
    {
        return r>=0 && r<n && c>=0 && c<m && grid[r][c] == 1;
    }

    private static int find(int u)
    {
        if(u == parent[u]) return u;
        return parent[u] = find(parent[u]);
    }

    private static void unionBySize(int u, int v)
    {
        int root_u = find(u);
        int root_v = find(v);
        if(u == v) return;
        if(root_u == root_v) return;

        if(size[root_v] > size[root_u])
        {
            parent[root_u] = root_v;
            size[root_v] += size[root_u];
        }
        else{
            parent[root_v] = root_u;
            size[root_u] += size[root_v];
        }
    }
}
