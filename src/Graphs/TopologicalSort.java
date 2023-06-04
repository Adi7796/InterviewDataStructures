package Graphs;

import java.util.*;
import java.util.stream.Stream;

//used for job scheduling algorithms
public class TopologicalSort {

    static int V=6;
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for(int i=0; i<V; i++)
            adjacencyList.add(new ArrayList<>());

        addEdge(adjacencyList, 0, 3);
        addEdge(adjacencyList, 0, 2);
        addEdge(adjacencyList, 3, 2);
        addEdge(adjacencyList, 2, 3);
        addEdge(adjacencyList, 2, 1);
        addEdge(adjacencyList, 5, 1);
        addEdge(adjacencyList, 1, 4);
        addEdge(adjacencyList, 5, 4);

        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<V; i++)
        {
            if(!visited[i])
                topologicalSortDFS(adjacencyList, visited, i, stack);
        }

        System.out.println("Topological sort order : ");
        while(!stack.isEmpty())
        {
            System.out.print(stack.pop()+ "\t");
        }
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adjacencyList, int u, int v)
    {
        adjacencyList.get(u).add(v);
    }

    public static void topologicalSortDFS(ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited, int u, Stack stack)
    {
        visited[u] = true;
        for(int i = 0; i<adjacencyList.get(u).size(); i++)
        {
            if(!visited[adjacencyList.get(u).get(i)])
                topologicalSortDFS(adjacencyList, visited, adjacencyList.get(u).get(i), stack);
        }

        stack.push(u);
    }
}
