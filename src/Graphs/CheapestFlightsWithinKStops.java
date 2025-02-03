package Graphs;

import java.util.*;

public class CheapestFlightsWithinKStops {
    static class Pair{
        int v;
        int wt;
        public Pair(int v,int wt){
            this.v = v;
            this.wt = wt;
        }
    }

    static class Tuple {
        int stops, vertex, cost;
        Tuple(int stops, int vertex, int cost) {
            this.stops = stops;
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
//        int n = 4;
//        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
//        int src = 0, dst = 3, k = 1;

        int n = 3, src = 0, dst = 2, k = 1;
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};

//        int n = 3;
//        int[][]flights = {{0,1,100},{1,2,100},{0,2,500}};
//        int src = 0, dst = 2, k = 0;

//        int n = 4;
//        int src = 0; int dst = 3; int k = 1;
//        int[][] flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};

        CheapestFlightsWithinKStops obj = new CheapestFlightsWithinKStops();
        System.out.println(obj.findCheapestPrice(n, flights, src, dst, k));
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
    {
        // Create the adjacency list to depict airports and flights in
        // the form of a graph.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for(int i = 0;i<m;i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        // Create a queue which stores the node and their distances from the
        // source in the form of {stops, {node, dist}} with ‘stops’ indicating
        // the no. of nodes between src and current node.
        Queue<Tuple> q = new LinkedList<>();

        q.add(new Tuple(0, src, 0));

        // Distance array to store the updated distances from the source.
        int[] dist = new int[n];
        for(int i = 0;i<n;i++) {
            dist[i] = (int)(1e9);
        }
        dist[src] = 0;

        // Iterate through the graph using a queue like in Dijkstra with
        // popping out the element with min stops first.
        while(!q.isEmpty()) {
            Tuple it = q.peek();
            q.remove();
            int stops = it.stops;
            int vertex = it.vertex;
            int cost = it.cost;

            // We stop the process as soon as the limit for the stops reaches.
            if(stops > k) continue;
            for(Pair iter: adj.get(vertex)) {
                int adjNode = iter.v;
                int edW = iter.wt;

                // We only update the queue if the new calculated dist is
                // less than the prev and the stops are also within limits.
                if (cost + edW < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edW;
                    q.add(new Tuple(stops + 1, adjNode, cost + edW));
                }
            }
        }
        // If the destination node is unreachable return ‘-1’
        // else return the calculated dist from src to dst.
        if(dist[dst] == (int)(1e9)) return -1;
        return dist[dst];
    }
}

/*
Time Complexity: O( N ) { Additional log(N) of time eliminated here because we’re using a simple queue rather than a priority queue which is usually used in Dijkstra’s Algorithm }.

Where N = Number of flights / Number of edges.

Space Complexity:  O( |E| + |V| ) { for the adjacency list, priority queue, and the dist array }.

Where E = Number of edges (flights.size()) and V = Number of Airports.
 */