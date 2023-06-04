package Graphs;

/* shortest path from src to dest. graph may contain negative edges.
Dijkstras algorithm fails for negative weights -> negative cycles
 */
public class BellmanFordAlgorithm {

    class Edge
    {
        int src, dest, weight;
        public Edge() { src=dest=weight=0; }
    }

    int V, E;
    Edge edge[];

    public BellmanFordAlgorithm(int v, int e)
    {
       V=v;
       E=e;
        edge = new Edge[e];
        for(int i=0;i<e;i++)
            edge[i] = new Edge();
    }

    public static void minPath(BellmanFordAlgorithm graph, int src)
    {
        int v = graph.V;
        int e = graph.E;

        int[] dist = new int[v];

        for(int i=0;i<v;i++)
            dist[i] = Integer.MAX_VALUE;

        dist[src] = 0;

        // run the loop for |V| -1 times
        /* Since in a graph of N nodes, in worst case you will take
        N-1 edges to reach from the first edge to the last, thereby we iterate
        for N-1 iterations.
         */
        for(int count = 1; count < v; count++) {
            for(int j = 0; j < e; j++)
            {
                int u = graph.edge[j].src;
                int z = graph.edge[j].dest;
                int wt = graph.edge[j].weight;

                if(dist[u] != Integer.MAX_VALUE && dist[z] > dist[u] + wt)
                    dist[z] = dist[u] + wt;
            }
        }

        /*
        check for negative-weight cycles. The
        above step guarantees shortest distances if graph
        doesn't contain negative weight cycle. If we get
        a shorter path, then there is a cycle.
         */
        for(int j =0; j< e; j++){
            int u = graph.edge[j].src;
            int z = graph.edge[j].dest;
            int wt = graph.edge[j].weight;

            if(dist[u] != Integer.MAX_VALUE && dist[z] > dist[u] + wt)
                System.out.println("Graph contains a negative cycle");
        }
        printDistArr(graph, dist);
    }

    public static void printDistArr(BellmanFordAlgorithm graph, int[] dist)
    {
        int v = graph.V;
        int e = graph.E;

        System.out.println("Vertex \t Distance from Source");
        for(int i=0; i<v; i++)
        {
            System.out.println(i +"\t \t\t"+ dist[i]);
        }
    }

    public static void main(String[] args)
    {
        int V=5;
        int E=8;

        BellmanFordAlgorithm graph = new BellmanFordAlgorithm(V,E);
        graph.edge[0].src=0;
        graph.edge[0].dest=1;
        graph.edge[0].weight=-1;

        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        // add edge 1-4 (or B-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;

        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;

        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;

        minPath(graph,0);
    }

}
