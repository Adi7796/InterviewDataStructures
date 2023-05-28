package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*Time Complexity: O(E * logV), Where E is the number of edges and V is the number of vertices.
        Auxiliary Space: O(V) */

public class DijkstrasAlgorithmPriorityQueue {

    static int V = 9;
    static class Pair implements Comparable<Pair>
    {
        int node;
        int dist;
        public Pair(int node, int dist)
        {
            this.dist=dist;
            this.node=node;
        }
        @Override
        public int compareTo(Pair pair) {
            return this.dist - pair.dist;
        }
    }
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Pair>> adjacencyList= new ArrayList<>();
        for(int v=0; v<V; v++)
        {
            adjacencyList.add(new ArrayList<Pair>());
        }
        addEdge(adjacencyList,0, 1, 4);
        addEdge(adjacencyList,0, 7, 8);
        addEdge(adjacencyList,1, 2, 8);
        addEdge(adjacencyList,1, 7, 11);
        addEdge(adjacencyList,2, 3, 7);
        addEdge(adjacencyList,2, 8, 2);
        addEdge(adjacencyList,2, 5, 4);
        addEdge(adjacencyList,3, 4, 9);
        addEdge(adjacencyList,3, 5, 14);
        addEdge(adjacencyList,4, 5, 10);
        addEdge(adjacencyList,5, 6, 2);
        addEdge(adjacencyList,6, 7, 1);
        addEdge(adjacencyList,6, 8, 6);
        addEdge(adjacencyList,7, 8, 7);

        shortestPath(adjacencyList,0);
    }

    public static void addEdge(ArrayList<ArrayList<Pair>> adjacencyList, int u, int v, int dist)
    {
        adjacencyList.get(u).add(new Pair(v, dist));
        adjacencyList.get(v).add(new Pair(u,dist));
    }

    public static void shortestPath(ArrayList<ArrayList<Pair>> adjacencyList, int src)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Pair(src, 0));
        dist[src]=0;
        while(!pq.isEmpty())
        {
            Pair cur = pq.remove();
            for(Pair neighbour : adjacencyList.get(cur.node))
            {
                int vertex = neighbour.node;
                int wt = neighbour.dist;
                if(dist[vertex] > dist[cur.node] + wt)
                {
                    dist[vertex] = dist[cur.node] + wt;
                    pq.add(new Pair(vertex, dist[vertex]));
                }

            }
        }

        printSolution(dist);
    }

    public static void printSolution(int[] dist)
    {
        System.out.println(
                "Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }
}
