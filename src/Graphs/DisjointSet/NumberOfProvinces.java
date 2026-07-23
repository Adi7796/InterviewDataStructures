package Graphs.DisjointSet;

/*
There are n cities. Some of them are connected, while some are not.
If city a is connected directly with city b, and city b is connected directly with city c,
then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected,
and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
 */
public class NumberOfProvinces {
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) {
        int[][] mat = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(mat));
    }

    public static int findCircleNum(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        rank = new int[m+1];
        parent = new int[m+1];

        for(int i=1; i<=m; i++)
        {
            rank[i] = 1;
            parent[i] = i;
        }

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(mat[i][j] == 1)
                {
                    union(i+1, j+1);
                }
            }
        }
        int cnt = 0;
        for(int i=1; i<=m; i++)
        {
            if(parent[i] == i) cnt++;
        }
        return cnt;
    }

    private static int findParent(int u)
    {
        if(parent[u] == u) return u;
        return parent[u] = findParent(parent[u]);
    }

    private static void union(int u, int v)
    {
        if(u == v) return;
        int root_u = findParent(u);
        int root_v = findParent(v);
        if(root_u == root_v) return;
        if(rank[root_u] > rank[root_v]){
            parent[root_v] = parent[root_u];
        }
        else if(rank[root_v] > rank[root_u]){
            parent[root_u] = parent[root_v];
        }
        else{
            parent[root_u] = parent[root_v];
            rank[root_v]++;
        }
    }
}
