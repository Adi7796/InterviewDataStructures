package Companies.Amazon;

import java.util.ArrayList;
import java.util.List;

/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.



Example 1:
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2

Example 2:
Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3

 */
public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0},
                {1,1,0},
                {0,0,1}};

        NumberOfProvinces obj = new NumberOfProvinces();
        System.out.println(obj.findCircleNum(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for(int i=1;i<=isConnected.length; i++)
        {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i=0;i<isConnected.length; i++)
        {
            for(int j=0; j<isConnected[i].length; j++)
            {
                if(isConnected[i][j] == 1)
                    adjacencyList.get(i).add(j+1);
            }
        }

        boolean isVisited[] = new boolean[isConnected.length];
        int provinces = 0;
        for(int i=1;i<=isConnected.length; i++)
        {
            if(!isVisited[i-1])
            {
                DFS(adjacencyList, isVisited, i);
                provinces++;
            }

        }
        return provinces;
    }

    public void DFS(List<List<Integer>> adjacencyList, boolean isVisited[], int vertex)
    {
        isVisited[vertex-1] = true;
        for(int i=0;i<adjacencyList.get(vertex-1).size(); i++)
        {
            int neighbour = adjacencyList.get(vertex-1).get(i);
            if(!isVisited[neighbour-1])
            {
                DFS(adjacencyList, isVisited, neighbour);
            }
        }
    }
}
