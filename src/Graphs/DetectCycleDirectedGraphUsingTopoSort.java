package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges,
check whether it contains any cycle or not.
The graph is represented as an adjacency list,
where adj[i] contains a list of vertices that are directly reachable from vertex i.
Specifically, adj[i][j] represents an edge from vertex ito vertex j.
 */
public class DetectCycleDirectedGraphUsingTopoSort {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] inDegree = new int[V];

        for(List<Integer> list : adj)
        {
            for(int vertex : list)
            {
                inDegree[vertex]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < inDegree.length; i++)
        {
            if(inDegree[i] == 0) queue.add(i);
        }



        int count = 0;
        while(!queue.isEmpty())
        {
            int node = queue.remove();
            count++;

            for(int adjNode : adj.get(node))
            {
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0)
                {
                    queue.add(adjNode);
                }
            }
        }
        return count == V ? false : true;

    }
}
