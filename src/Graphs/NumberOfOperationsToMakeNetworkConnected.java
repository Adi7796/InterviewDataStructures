package Graphs;

/*
There are n computers numbered from 0 to n - 1 connected by ethernet cables
connections forming a network where connections[i] = [ai, bi] represents a
connection between computers ai and bi. Any computer can reach any other computer
directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain
cables between two directly connected computers, and place them between any pair
of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all
the computers connected. If it is not possible, return -1.

Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.

Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
Output: 2
Example 3:

Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
Output: -1
Explanation: There are not enough cables.
 */
public class NumberOfOperationsToMakeNetworkConnected {

    static int[] parent;
    static int[] rank;

    public static void main(String[] args) {
        int n = 4;
        int[][] connections = {{0, 1}, {0, 2}, {1, 2}};

        System.out.println(makeConnected(n, connections));
    }
    public static int makeConnected(int n, int[][] connections)
    {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i<n; i++)
        {
            parent[i] = i;
            rank[i] = 0;
        }

        int m = connections.length;
        int extraEdges = 0;
        int noConnComp = 0;
        for(int i = 0;i < m; i++)
        {
            int u = connections[i][0];
            int v = connections[i][1];

            // if the parent matches, that means we have already unioned the vertices
            // this might be a repeating edge which can be removed
            if(findParent(u) == findParent(v))
            {
                extraEdges++;
            }
            // else we can union the vertices
            else{
                unionByRank(u, v);
            }
        }

        // no of connected components = no. of times one of the vertex is itself's parent
        for(int i = 0; i< n; i++){
            if(parent[i] == i) noConnComp++;
        }

        // we would require no of connected components - 1 edges to connect all the components
        int ans = noConnComp -1;

        // we need to remove one of the extra edges to make an edge between the un-connected components
        // hence only if extraEdges >= ans we can connect all the components
        if(extraEdges >= ans) return ans;
        return -1;
    }

    public static void unionByRank(int u, int v)
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

    public static int findParent(int u)
    {
        if(parent[u] == u)
        {
            return u;
        }
        return parent[u] = findParent(parent[u]);
    }
}
