package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
You are given an adjacency list, adj of Undirected Graph having unit weight of the edges,
find the shortest path from src to all the vertex and if
it is unreachable to reach any vertex, then return -1 for that vertex.

Input: adj[][] = [[1, 3], [0, 2], [1, 6], [0, 4], [3, 5], [4, 6], [2, 5, 7, 8], [6, 8], [7, 6]], src=0
Output: [0, 1, 2, 1, 2, 3, 3, 4, 4]
 */
public class ShortestPathUndirectedGraph {

    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        Queue<Integer> queue = new LinkedList<>();
        int n = adj.size();
        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        queue.add(src);
        dist[src] = 0;

        while(!queue.isEmpty())
        {
            int node = queue.remove();
            for(int adjNode : adj.get(node))
            {
                if(dist[node] + 1 < dist[adjNode])
                {
                    dist[adjNode] = 1 + dist[node];
                    queue.add(adjNode);
                }
            }
        }

        for(int i = 0; i<dist.length; i++)
        {
            if(dist[i] == Integer.MAX_VALUE)
            {
                dist[i] = -1;
            }
        }

        return dist;

    }
}
