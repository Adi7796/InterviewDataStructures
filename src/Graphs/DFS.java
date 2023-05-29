package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class DFS {
    public static void main(String[] args){
        int v=6;
        LinkedList<LinkedList<Integer>> adjacencyList = new LinkedList<>();
        for(int i=0;i<v;i++){
            adjacencyList.add(new LinkedList<Integer>());
        }
        addEdge(0,1,adjacencyList);
        addEdge(0,2,adjacencyList);
        addEdge(1,3,adjacencyList);
        addEdge(1,2,adjacencyList);
        addEdge(4,5,adjacencyList);

        boolean[] visited = new boolean[v];
        //ArrayList<Integer> traversalList = new ArrayList<>();
        int components = 0 ;

        for (int i=1; i<v; i++){
            visited[i] = false;
        }
        for(int i=0; i<v; i++)
        {
            if(!visited[i]){
                ArrayList<Integer> traversalList = dfsTraversal(i,adjacencyList,visited, new ArrayList<Integer>());
                components++;
                System.out.println("Traversal list for connected component "+components+ ": "+traversalList);
            }

        }
        System.out.println("Components : "+components);
    }

    public static void addEdge(int source, int dest, LinkedList<LinkedList<Integer>> list){
        list.get(source).add(dest);
        list.get(dest).add(source);
    }

    public static ArrayList<Integer> dfsTraversal(int v, LinkedList<LinkedList<Integer>> adjacencyList, boolean[] visited, ArrayList<Integer> traversalList){
        traversalList.add(v);
        visited[v] = true;
        for(Integer neighbour : adjacencyList.get(v)){
            if(!visited[neighbour]){
                dfsTraversal(neighbour,adjacencyList,visited, traversalList);
            }
        }
        return traversalList;
    }
}
