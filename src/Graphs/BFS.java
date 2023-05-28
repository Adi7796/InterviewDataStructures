package Graphs;

import java.util.Arrays;
import java.util.LinkedList;

public class BFS {
    public static void main(String[] args){
        int v=6;
        int e=8;
        LinkedList<LinkedList<Integer>> adjacencyList = new LinkedList<>();
        for(int i=0;i<v;i++){
           adjacencyList.add(new LinkedList<Integer>());
        }
        addEdge(0,1,adjacencyList);
        addEdge(0,2,adjacencyList);
        addEdge(2,3,adjacencyList);
        addEdge(3,4,adjacencyList);
        addEdge(1,4,adjacencyList);
        addEdge(3,5,adjacencyList);
        addEdge(4,5,adjacencyList);

        boolean[] visited = new boolean[v];
        int[] predecessor = new int[v];
        int[] distance = new int[v];

        for (int i=1; i<v; i++){
            visited[i] = false;
            distance[i] = Integer.MAX_VALUE;
            predecessor[i] = -1;
        }

        boolean isReached = bfsTraversal(0,5,v,e,adjacencyList,distance,predecessor,visited);

        System.out.println(isReached);
        System.out.println(Arrays.toString(Arrays.stream(distance).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(predecessor).toArray()));

    }

    public static void addEdge(int source, int dest, LinkedList<LinkedList<Integer>> list){
        list.get(source).add(dest);
        list.get(dest).add(source);
    }

    public static boolean bfsTraversal(int src, int dest, int v, int e,
                                       LinkedList<LinkedList<Integer>> list, int[] distance, int[] predecessor,
                                       boolean[] visited)
    {
        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(src);
        distance[src]=0;
        visited[src]=true;
        predecessor[src]= src;

        while(!queue.isEmpty())
        {
            int cur = queue.remove();
            for(int u=0; u<list.get(cur).size(); u++)
            {
                int neighbour = list.get(cur).get(u);
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    distance[neighbour] = distance[cur] + 1;
                    predecessor[neighbour] = cur;
                    queue.add(neighbour);

                    if(neighbour == dest)
                        return true;
                }
            }
        }
        return false;
    }
}
