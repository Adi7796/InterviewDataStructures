package Graphs;

/*
This algorithms is used to find the shortest path from source to all the vertices in a weighted graph
 */

/* Time Complexity: O(V2)
 Auxiliary Space: O(V)  */

public class DijkstrasAlgorithm {

    static int V = 9;
    public static void main(String[] args)
    {

        int graph[][]
                = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        dijkstra(graph,0);

    }

    public static void dijkstra(int[][] graph, int src)
    {
        boolean[] mstSet = new boolean[V];
        int[] dist = new int[V];

        for(int i=0;i<V; i++){
            dist[i]=Integer.MAX_VALUE;
            mstSet[i]=false;
        }

        dist[src] = 0;

        for(int count=0; count<V; count++)
        {
            int u = minDist(dist, mstSet);
            mstSet[u]=true;

            for(int v=0;v<V;v++)
            {
                if(!mstSet[v] && graph[u][v] !=0
                    && dist[u] != Integer.MAX_VALUE
                    && dist[u] + graph[u][v] <= dist[v])
                    dist[v] = dist[u] + graph[u][v];
            }
        }
        printSolution(dist);
    }

    public static int minDist(int[] dist, boolean[] mstSet)
    {
        int minIndex =-1;
        int min = Integer.MAX_VALUE;
        for(int v=0; v<V; v++)
        {
            if(!mstSet[v] && dist[v]<=min)
            {
                min = dist[v];
                minIndex=v;
            }
        }
         return minIndex;
    }

    public static void printSolution(int[] dist)
    {
        System.out.println(
                "Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }
}
