package Graphs;

import java.util.*;

/*
You are given a network of n nodes, labeled from 1 to n. You are also given times,
a list of travel times as directed edges
times[i] = (ui, vi, wi), where ui is the source node, vi is the target node,
and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes
for all the n nodes to receive the signal. If it is impossible for all the
n nodes to receive the signal, return -1.

Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 */
public class NetworkDelayTime {

    class Node implements Comparable<Node>
    {
        int v;
        int wt;

        Node(int v, int wt)
        {
            this.v = v;
            this.wt = wt;
        }

        public int compareTo(Node node){ return this.wt - node.wt; }

        @Override
        public String toString() {
            return "Node{" +
                    "v=" + v +
                    ", wt=" + wt +
                    '}';
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Node>> adjMap = new HashMap<>();
        int a = times.length;
        int[] dist = new int[n];
        for(int i = 0; i < n; i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i<a; i++)
        {
            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];

            if(!adjMap.containsKey(u))
            {
                List<Node> list = new ArrayList<>();
                list.add(new Node(v, wt));
                adjMap.put(u, list);
            }
            else
            {
                List<Node> list = adjMap.get(u);
                list.add(new Node(v, wt));
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[k-1] = 0;
        pq.add(new Node(k, 0));
        //int maxTime = Integer.MIN_VALUE;

        while(!pq.isEmpty())
        {
            Node node = pq.remove();
            int v = node.v;
            int wt = node.wt;

            //maxTime = Math.max(maxTime, dist[v-1]);
            List<Node> list = adjMap.get(v);
            if(list != null)
            {
                for(Node adjNode : list)
                {
                    if(dist[adjNode.v-1] > dist[v-1] + adjNode.wt)
                    {
                        dist[adjNode.v-1] = dist[v-1] + adjNode.wt;
                        pq.add(new Node(adjNode.v, adjNode.wt));
                    }
                }
            }

        }

        int maxTime = Integer.MIN_VALUE;
        for(int i = 0; i<dist.length; i++)
        {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }
}

/*
Time complexity: O(N+ElogN)

Dijkstra's Algorithm takes O(ElogN).
Finding the minimum time required in signalReceivedAt takes O(N).

Space complexity: O(N+E)
 */