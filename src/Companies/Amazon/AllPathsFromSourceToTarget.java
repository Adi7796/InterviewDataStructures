package Companies.Amazon;

import java.util.ArrayList;
import java.util.List;

/*
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).



Example 1:


Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Example 2:


Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 */
public class AllPathsFromSourceToTarget {

    public static void main(String[] args) {

        int[][] graph = {{1,2},{3},{3},{}};
        AllPathsFromSourceToTarget obj = new AllPathsFromSourceToTarget();

        List<List<Integer>> ans = obj.allPathsSourceTarget(graph);

        for(List<Integer> list : ans)
        {
            System.out.println(list);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        List<List<Integer>> pathList = new ArrayList<>();
        for(int i=0;i<graph.length; i++)
        {
            adjacencyList.add(new ArrayList<Integer>());
        }

        for(int i=0;i<graph.length; i++)
        {
            for(int j=0;j< graph[i].length; j++)
            {
                adjacencyList.get(i).add(graph[i][j]);
            }
        }

        List<Integer> subList = new ArrayList<>();
        boolean visitedSet[] = new boolean[graph.length];
        subList.add(0);
        DFS(0, graph.length-1, adjacencyList, pathList, subList, visitedSet);
        return pathList;
    }

    public void DFS(int source, int destination, List<List<Integer>> adjacencyList, List<List<Integer>> pathList,
                    List<Integer> subList, boolean[] visitedSet)
    {
        visitedSet[source] = true;
        for(int i=0; i < adjacencyList.get(source).size(); i++)
        {
            int neighbour = adjacencyList.get(source).get(i);
            if(neighbour == destination)
            {
                visitedSet[neighbour] = true;
                subList.add(destination);
                pathList.add(new ArrayList<>(subList));
                subList.remove(subList.size()-1);

            }
            if(!visitedSet[neighbour]){
                subList.add(neighbour);
                DFS(neighbour, destination, adjacencyList, pathList, subList,visitedSet);
                subList.remove(subList.size()-1);
                visitedSet[neighbour] = false;
            }

        }
    }
}
