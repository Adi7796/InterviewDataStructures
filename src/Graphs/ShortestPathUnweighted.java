package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUnweighted {

    static int V=8;
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for(int i=0; i<V; i++)
            adjacencyList.add(new ArrayList<>());

        addEdge(adjacencyList, 0, 1);
        addEdge(adjacencyList, 0, 3);
        addEdge(adjacencyList, 1, 2);
        addEdge(adjacencyList, 3, 4);
        addEdge(adjacencyList, 3, 7);
        addEdge(adjacencyList, 4, 5);
        addEdge(adjacencyList, 4, 6);
        addEdge(adjacencyList, 4, 7);
        addEdge(adjacencyList, 5, 6);
        addEdge(adjacencyList, 6, 7);

        int[] parent = new int[V];
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        for(int i=0;i<V;i++)
        {
            parent[i]=-1;
            dist[i]=Integer.MAX_VALUE;
            visited[i]=false;
        }

        int src  = 0, dest =7;
        shortestPathBFS(adjacencyList, src, dest, parent, dist, visited);

        LinkedList<Integer> path = new LinkedList<>();
        int crawl = dest;
        path.add(crawl);
        while(parent[crawl] != -1)
        {
            path.add(parent[crawl]);
            crawl = parent[crawl];
        }

        System.out.println("Distance of destination from src :"+ dist[dest]);
        System.out.println("Path from src to dest : ");

        for(int i = path.size() -1; i>=0; i--)
            System.out.print(path.get(i) + "\t");
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adjacencyList, int u, int v)
    {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }

    public static void shortestPathBFS(ArrayList<ArrayList<Integer>> adjacencyList, int src, int dest, int[] parent, int[] dist, boolean[] visited)
    {
        Queue<Integer> queue = new LinkedList<>();

        dist[src]=0;
        queue.add(src);
        visited[src]=true;

        while(!queue.isEmpty())
        {
            int node = queue.remove();
            for(Integer neighbour : adjacencyList.get(node))
            {
                if(!visited[neighbour] && dist[neighbour] > dist[node] + 1){
                    parent[neighbour] = node;
                    visited[neighbour] = true;
                    dist[neighbour] = dist[node] + 1;
                    queue.add(neighbour);

                    if(neighbour == dest)
                        return;
                }
            }
        }
    }
}
