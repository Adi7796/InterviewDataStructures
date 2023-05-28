package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

    static class Pair implements Comparable<Pair>{
        int v;
        int wt;
        Pair(int v, int wt)
        {
            this.v=v;
            this.wt=wt;
        }

        @Override
        public int compareTo(Pair pair) {
            return this.wt - pair.wt;
        }
    }
    public static void main(String[] args){
        int v=5;
        boolean[] visited = new boolean[v];
        ArrayList<ArrayList<Pair>> adjacencyList = new ArrayList<>();
        for(int i=0; i<v; i++) {
            adjacencyList.add(new ArrayList<>());
            visited[i] = false;
        }

        addEdge(adjacencyList, 0,1,2);
        addEdge(adjacencyList,0,4,6);
        addEdge(adjacencyList, 1, 4,4);
        addEdge(adjacencyList, 1, 2,1);
        addEdge(adjacencyList, 2, 4, 2);
        addEdge(adjacencyList, 0, 3, 7);
        addEdge(adjacencyList, 4, 3,5);
        addEdge(adjacencyList, 2, 3, 3);


        System.out.println("Min MST : "+minMst(adjacencyList, visited, 0, 0));
    }

    public static void addEdge(ArrayList<ArrayList<Pair>> adjacencyList,int u, int v, int wt)
    {
        adjacencyList.get(u).add(new Pair(v, wt));
        adjacencyList.get(v).add(new Pair(u, wt));
    }

    public static int minMst(ArrayList<ArrayList<Pair>> adjacencyList, boolean[] visited, int src, int initialWt)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,initialWt));
        int ans = 0;
        System.out.println("Vertex----Weight");
        while(!pq.isEmpty())
        {
            Pair cur = pq.remove();
            if(visited[cur.v])
                continue;
            ans+=cur.wt;
            visited[cur.v]=true;
            System.out.println(cur.v+ "  --------  " +cur.wt);
            for(Pair neighbour : adjacencyList.get(cur.v))
            {
                if(!visited[neighbour.v]){
                    pq.add(new Pair(neighbour.v, neighbour.wt));
                }
            }
        }
        return ans;
    }
}
