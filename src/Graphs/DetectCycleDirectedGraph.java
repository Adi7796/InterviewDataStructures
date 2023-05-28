package Graphs;

import java.util.LinkedList;

public class DetectCycleDirectedGraph {
    public static void main(String[] args) {
        int v = 5;
        LinkedList<LinkedList<Integer>> adjacencyList = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            adjacencyList.add(new LinkedList<Integer>());
        }
        addEdge(0, 1, adjacencyList);
        addEdge(2, 1, adjacencyList);
        addEdge(2, 3, adjacencyList);
        addEdge(3, 4, adjacencyList);
        addEdge(4, 2, adjacencyList);

        boolean[] visited = new boolean[v];
        boolean[] recusiveStack = new boolean[v];

        int components = 0;

        for (int i = 1; i < v; i++) {
            visited[i] = false;
            recusiveStack[i]= false;
        }
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                boolean isCycle = isCyclePresent(i, visited, recusiveStack,adjacencyList);
                components++;
                System.out.println("Cycle present for connected component " + components + ": " + isCycle);
            }

        }
    }

    public static void addEdge(int source, int dest, LinkedList<LinkedList<Integer>> list){
        list.get(source).add(dest);
    }

    public static boolean isCyclePresent(int v, boolean[] visited, boolean[] recusiveStack,LinkedList<LinkedList<Integer>> adjacencyList)
    {
        visited[v] = true;
        recusiveStack[v] = true;
        for(Integer neighbour : adjacencyList.get(v))
        {
            if(!visited[neighbour]){
                if(isCyclePresent(neighbour, visited,recusiveStack,adjacencyList))
                    return true;
            }
            else if(recusiveStack[neighbour])
                return true;
        }
        recusiveStack[v] = false;
        return false;
    }

}
