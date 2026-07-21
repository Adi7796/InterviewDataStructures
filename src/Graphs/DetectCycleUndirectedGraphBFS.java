package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleUndirectedGraphBFS {

    static class Node {
        int curr;
        int src;

        public Node(int curr, int src)
        {
            this.curr = curr;
            this.src = src;
        }
    }
    public static void main(String[] args){
        int V = 4;
        int[][] edges = {{0, 1},{0, 2}, {1, 2}, {2, 3}};

        System.out.println(isCycle(V, edges));
    }

    public static boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++)
        {
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0; i<edges.length; i++)
        {
            addEdge(edges[i][0], edges[i][1], adj);
        }

        boolean[] visited = new boolean[V];

        for(int i=0; i<V; i++)
        {
            if(!visited[i])
            {
                if(bfs(adj, visited, i)) return true;
            }
        }
        return false;
    }

    private static void addEdge(int u, int v, ArrayList<ArrayList<Integer>> adj)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    private static boolean bfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int source)
    {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(source, -1));
        visited[source] = true;

        while(!que.isEmpty())
        {
            Node node = que.poll();
            for(int i=0; i<adj.get(node.curr).size(); i++)
            {
                int neighbour = adj.get(node.curr).get(i);
                if(neighbour == node.src) continue;
                else if(neighbour != node.src && visited[neighbour]) return true;
                else if(!visited[neighbour]){
                    visited[neighbour] = true;
                    que.add(new Node(neighbour, node.curr));
                }
            }
        }

        return false;
    }
}
