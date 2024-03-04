package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Topological sorting using BFS
// We use in degree concept to topologically sort
// InDegree : no of incoming edges to a vertex
// we sequentially enqueue vertices having 0 in degree as those vertices will have the least dependency in increasing manner
// the element inserted in the beginning will have the least dependency and the one inserted at last will have max
public class KahnsAlgorithm {

    static int V = 6;
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for(int i=0; i<V; i++)
            adjacencyList.add(new ArrayList<>());

        addEdge(adjacencyList, 0, 3);
        addEdge(adjacencyList, 0, 2);
        addEdge(adjacencyList, 2, 3);
        addEdge(adjacencyList, 3, 1);
        addEdge(adjacencyList, 2, 1);
        addEdge(adjacencyList, 5, 1);
        addEdge(adjacencyList, 5, 4);
        addEdge(adjacencyList, 1, 4);

        int[] inDegree = new int[V];
        ArrayList<Integer> ans = new ArrayList<>();

        for(ArrayList<Integer> list : adjacencyList){
            for(Integer i : list) {
                inDegree[i]++;
            }
        }

        System.out.println("In degree array :-");
        for(Integer i: inDegree)
            System.out.print(i + " ");

        System.out.println();
        TopoSortBFS(adjacencyList, inDegree, ans);

        System.out.println("Topological Sort order :-");
        for(Integer i: ans)
            System.out.print(i + " ");

    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adjacencyList, int u, int v)
    {
        adjacencyList.get(u).add(v);
    }

    public static void TopoSortBFS(ArrayList<ArrayList<Integer>> adjacencyList, int[] inDegree, ArrayList<Integer> ans)
    {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<V;i++)
        {
            if(inDegree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty())
        {
            int current = queue.poll();
            ans.add(current);
            for(Integer neighbour : adjacencyList.get(current)) {
                if(--inDegree[neighbour] == 0){
                    queue.add(neighbour);
                }
            }
        }

    }
}
