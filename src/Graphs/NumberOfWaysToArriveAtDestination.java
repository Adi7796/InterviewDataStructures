package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
You are in a city that consists of n intersections numbered from 0 to n - 1
with bi-directional roads between some intersections. The inputs are generated
such that you can reach any intersection from any other intersection and that
there is at most one road between any two intersections.

You are given an integer n and a 2D integer array roads where roads[i] =
[ui, vi, timei] means that there is a road between intersections ui and vi that
takes timei minutes to travel. You want to know in how many ways you can travel
from intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest
amount of time. Since the answer may be large, return it modulo 109 + 7.

Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1]
,[2,5,1],[0,4,5],[4,6,2]]
Output: 4
Explanation: The shortest amount of time it takes to go from intersection
0 to intersection 6 is 7 minutes.
The four ways to get there in 7 minutes are:
- 0 ➝ 6
- 0 ➝ 4 ➝ 6
- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
Example 2:

Input: n = 2, roads = [[1,0,10]]
Output: 1
Explanation: There is only one way to go from intersection 0 to intersection 1,
and it takes 10 minutes.
 */
public class NumberOfWaysToArriveAtDestination {

    static class Pair implements Comparable<Pair>{
        int node;
        int dist;

        Pair(int node, int dist)
        {
            this.node = node;
            this.dist = dist;
        }

        public int compareTo(Pair p)
        {
            return this.dist - p.dist;
        }
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},
                {3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};

        System.out.println(countPaths(n, roads));
    }
    public static int countPaths(int n, int[][] roads) {
        List<List<Pair>> adjList = new ArrayList<>();

        for(int i = 0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }

        int m = roads.length;
        for(int i = 0; i<m; i++)
        {
            adjList.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adjList.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }

        int[] ways = new int[n];
        int[] dist = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        ways[0] = 1;
        dist[0] = 0;
        int mod = (int)(1e9+7);
        for(int i = 1; i<n; i++)
        {
            ways[i] = 0;
            dist[i] = (int)1e9;
        }

        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int node = p.node;
            int distance = p.dist;

            for(Pair adjPair : adjList.get(node))
            {
                int adjNode = adjPair.node;
                int edw = adjPair.dist;

                if(dist[adjNode] > distance + edw)
                {
                    dist[adjNode] = distance + edw;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(adjNode, edw + distance));
                }
                else if(dist[adjNode] == distance + edw)
                {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n-1] % mod;
    }

}
