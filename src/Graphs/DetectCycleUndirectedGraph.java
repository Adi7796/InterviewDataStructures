package Graphs;

import java.util.LinkedList;

public class DetectCycleUndirectedGraph {
    public static void main(String[] args){
        int v=7;
        LinkedList<LinkedList<Integer>> adjacencyList = new LinkedList<>();
        for(int i=0;i<v;i++){
            adjacencyList.add(new LinkedList<>());
        }
        addEdge(0,1,adjacencyList);
        addEdge(1,2,adjacencyList);
        addEdge(1,3,adjacencyList);
        addEdge(2,3,adjacencyList);
        addEdge(4,5,adjacencyList);
        addEdge(5,6,adjacencyList);

        boolean[] visited = new boolean[v];
        //ArrayList<Integer> traversalList = new ArrayList<>();
        int components = 0 ;

        for (int i=1; i<v; i++){
            visited[i] = false;
        }
        for(int i=0; i<v; i++)
        {
            if(!visited[i]){
                boolean isCycle = isCyclePresent(i,visited,adjacencyList, -1);
                components++;
                System.out.println("Cycle present for connected component "+components+ ": "+isCycle);
            }

        }
    }

    public static void addEdge(int source, int dest, LinkedList<LinkedList<Integer>> list){
        list.get(source).add(dest);
        list.get(dest).add(source);
    }

    public static boolean isCyclePresent(int v, boolean[] visited, LinkedList<LinkedList<Integer>> adjacencyList, int parent)
    {
        visited[v] = true;
        for(Integer neighbour : adjacencyList.get(v))
        {
            if(!visited[neighbour]){
                if(isCyclePresent(neighbour, visited, adjacencyList, v))
                    return true;
            }
            else if(parent != neighbour)
                return true;
        }
        return false;
    }
}
