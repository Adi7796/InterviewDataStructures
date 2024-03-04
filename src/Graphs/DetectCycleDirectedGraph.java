package Graphs;

import java.util.LinkedList;

/*
Create a recursive dfs function that has the following parameters – current vertex, visited array, and recursion stack.
Mark the current node as visited and also mark the index in the recursion stack.
Iterate a loop for all the vertices and for each vertex, call the recursive function if it is not yet visited
(This step is done to make sure that if there is a forest of graphs, we are checking each forest):
In each recursion call, Find all the adjacent vertices of the current vertex which are not visited:
If an adjacent vertex is already marked in the recursion stack then return true.
Otherwise, call the recursive function for that adjacent vertex.
While returning from the recursion call, unmark the current node from the recursion stack,
to represent that the current node is no longer a part of the path being traced.
If any of the functions returns true, stop the future function calls and return true as the answer.
 */
public class DetectCycleDirectedGraph {
    public static void main(String[] args) {
        int v = 5;
        LinkedList<LinkedList<Integer>> adjacencyList = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            adjacencyList.add(new LinkedList<>());
        }
        addEdge(0, 1, adjacencyList);
        addEdge(2, 1, adjacencyList);
        addEdge(2, 3, adjacencyList);
        addEdge(3, 4, adjacencyList);
        addEdge(4, 2, adjacencyList);

        boolean[] visited = new boolean[v];
        boolean[] recursiveStack = new boolean[v];

        int components = 0;

        for (int i = 1; i < v; i++) {
            visited[i] = false;
            recursiveStack[i]= false;
        }
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                boolean isCycle = isCyclePresent(i, visited, recursiveStack,adjacencyList);
                components++;
                System.out.println("Cycle present for connected component " + components + ": " + isCycle);
            }

        }
    }

    public static void addEdge(int source, int dest, LinkedList<LinkedList<Integer>> list){
        list.get(source).add(dest);
    }

    public static boolean isCyclePresent(int v, boolean[] visited, boolean[] recursiveStack,LinkedList<LinkedList<Integer>> adjacencyList)
    {
        if(recursiveStack[v])
            return true;

        if(visited[v])
            return false;

        visited[v] = true;
        recursiveStack[v] = true;

        for(Integer i : adjacencyList.get(v))
        {
            if(isCyclePresent(i, visited, recursiveStack, adjacencyList))
                return true;
        }

        recursiveStack[v] = false;
        return false;
    }

}
