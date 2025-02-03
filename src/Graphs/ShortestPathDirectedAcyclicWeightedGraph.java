package Graphs;

import java.util.*;

public class ShortestPathDirectedAcyclicWeightedGraph {

    static class Pair{
        int vertex;
        int weight;

        Pair(int vertex, int weight)
        {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        int V = 6;
        int E = 7;
        int[][] edges = {{0,1,2}, {0,4,1}, {4,5,4}, {4,2,2}, {1,2,3}, {2,3,6}, {5,3,1}};
//        int V = 4;
//        int E = 2;
//        int[][] edges = {{0,1,2}, {0,2,1}};

        int[] path = shortestPath(V, E, edges);
        for(int i : path)
        {
            System.out.print(i + " ");
        }
    }

    public static int[] shortestPath(int V, int E, int[][] edges) {
        // Code here

        List<List<Pair>> adjList = new ArrayList<>();

        for(int i = 0; i<V; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i<E; i++)
        {
            adjList.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }

        List<Integer> orderList = topoSort(adjList, V);
        int dist[] = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[orderList.get(0)] = 0;

        for(int i : orderList)
        {
            for(Pair adjNode : adjList.get(i))
            {
                int vertex = adjNode.vertex;
                int weight = adjNode.weight;

                if(dist[vertex] > dist[i] + weight)
                {
                    dist[vertex] = dist[i] + weight;
                }
            }
        }

        for(int j = 0; j<dist.length;j++)
        {
            if(dist[j] == Integer.MAX_VALUE)
            {
                dist[j] = -1;
            }
        }

        return dist;
    }

    static List<Integer> topoSort(List<List<Pair>> adjList, int V)
    {
        int[] inDegree = new int[V];
        Arrays.fill(inDegree, 0);

        for(List<Pair> pairList : adjList)
        {
            for(int i = 0; i<pairList.size(); i++)
            {
                inDegree[pairList.get(i).vertex]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i : inDegree){
            if(i == 0) queue.add(i);
        }

        List<Integer> orderList = new ArrayList<>();
        while(!queue.isEmpty())
        {
            int node = queue.remove();
            orderList.add(node);
            for(Pair adjNode: adjList.get(node))
            {
                inDegree[adjNode.vertex]--;
                if(inDegree[adjNode.vertex] == 0)
                {
                    queue.add(adjNode.vertex);
                }
            }
        }
        return orderList;
    }
}
