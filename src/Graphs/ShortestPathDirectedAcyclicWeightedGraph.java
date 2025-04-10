package Graphs;

import java.util.*;

/*
Given a Directed Acyclic Graph of V vertices from 0 to n-1 and a
2D Integer array(or vector) edges[ ][ ] of length E, where there
is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.

Find the shortest path from src(0) vertex to all the vertices and
if it is impossible to reach any vertex, then return -1 for that vertex

Examples :

Input: V = 4, E = 2, edges = [[0,1,2], [0,2,1]]
Output: [0, 2, 1, -1]
Explanation: Shortest path from 0 to 1 is 0->1 with edge weight 2.
Shortest path from 0 to 2 is 0->2 with edge weight 1. There is no way we
can reach 3, so it's -1 for 3.

Input: V = 6, E = 7, edges = [[0,1,2], [0,4,1], [4,5,4], [4,2,2], [1,2,3], [2,3,6], [5,3,1]]
Output: [0, 2, 3, 6, 1, 5]
Explanation: Shortest path from 0 to 1 is 0->1 with edge weight 2.
Shortest path from 0 to 2 is 0->4->2 with edge weight 1+2=3.
Shortest path from 0 to 3 is 0->4->5->3 with edge weight 1+4+1=6.
Shortest path from 0 to 4 is 0->4 with edge weight 1.
Shortest path from 0 to 5 is 0->4->5 with edge weight 1+4=5.
 */
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
        int V = 4, E = 2;
        int[][] edges = {{0,1,2}, {0,2,1}};
        int[] ans = shortestPath(4, 2, edges);

        for(int i : ans)
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

/*
Finding the shortest path to a vertex is easy if you already know the shortest paths to all the vertices that can precede it.
Processing the vertices in topological order ensures that by the time you get to a vertex, you've already processed all the
vertices that can precede it which reduces the computation time significantly. In this approach, we traverse the nodes
sequentially according to their reachability from the source.

Dijkstra's algorithm is necessary for graphs that can contain cycles because they can't be topologically sorted.
In other cases, the topological sort would work fine as we start from the first node, and then move on to the others
in a directed manner.

Time Complexity: O(N+M) {for the topological sort} + O(N+M) {for relaxation of vertices, each node and its adjacent nodes get traversed} ~ O(N+M).

Where N= number of vertices and M= number of edges.

Space Complexity:  O( N) {for the stack storing the topological sort} + O(N) {for storing the shortest distance for each node} + O(N) {for the visited array} + O( N+2M) {for the adjacency list} ~ O(N+M) .

Where N= number of vertices and M= number of edges.
 */