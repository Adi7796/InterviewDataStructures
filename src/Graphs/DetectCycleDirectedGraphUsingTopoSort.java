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

If a directed graph contains a cycle, the indegree of the nodes that are
parts of that cycle will never be 0 due to the cyclic dependency.
But in that algorithm, we push a node into the queue only if its in-degree becomes 0.
So, those nodes of the cycle will never be pushed into the queue as well as included
in the topological sorting. And here it violates the rules of topological sorting as
topological sorting is a linear ordering of all V vertices (i.e. All V vertices must
be present in that ordering).
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

/*
Time Complexity: O(V+E), where V = no. of nodes and E = no. of edges.
This is a simple BFS algorithm.

Space Complexity: O(N) + O(N) ~ O(2N), O(N) for the in-degree array,
and O(N) for the queue data structure used in BFS(where N = no.of nodes).
 */