package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an undirected graph with V vertices labelled from 0 to V-1 and E edges,
check whether the graph contains any cycle or not.
The Graph is represented as an adjacency list,
where adj[i] contains all the vertices that are directly connected to vertex i.

NOTE: The adjacency list represents undirected edges, meaning that if there is
an edge between vertex i and vertex j, both j will be adj[i] and i will be in adj[j].
 */
public class UndirectedGraphCycleDFS {

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int V = adj.size();
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        for(int i = 0; i<V; i++)
        {
            if(!visited[i]){
                if(dfs(adj, visited, i, -1))
                    return true;
            }
        }

        return false;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited,int node, int parent)
    {
        visited[node] = true;

        for(int i : adj.get(node))
        {
            if(!visited[i])
            {
                if(dfs(adj, visited, i, node) == true)
                    return true;
            }
            else if(i != parent)
            {
                return true;
            }
        }
        return false;
    }
}
