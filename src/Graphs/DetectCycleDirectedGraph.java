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
        // first mark both the vis and recStack as true
        recursiveStack[v] = true;
        visited[v] = true;

        // iterate over all the adj nodes of the vertex v
        for(Integer i : adjacencyList.get(v))
        {
            // if the adj node is not visited, call the dfs function again on the adj node
            if(!visited[i]){
                if(isCyclePresent(i, visited, recursiveStack, adjacencyList)) return true;
            }
            // if the adjnode is visited, check if we have seen this node in the same recursive call
            // if we have, that means we are visiting this vertex again in the same recursive call and hence cycle is present
            else if(recursiveStack[i]){
                return true;
            }
        }
        // backtrack and mark this node as not false in the recStack
        recursiveStack[v] = false;
        // return false as we didn't find any cycle
        return false;
    }

}

/*
Time Complexity: O(V + E), since in its whole, it is a DFS implementation, V – vertices; E – edges;

Space Complexity: O(V), because, apart from the graph,
we have 2 arrays of size V, to store the required information
 */
