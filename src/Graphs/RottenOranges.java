package Graphs;

// Min time to rot all oranges
// 0: Empty cell
// 1: Cells have fresh oranges
// 2: Cells have rotten oranges

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    static class Node{
        int x;
        int y;
        Node(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args)
    {
        int[][] graph = { { 2, 1, 0, 2, 1 },
                { 1, 0, 1, 2, 1 },
                { 1, 0, 0, 2, 1 } };

        int m = graph.length;
        int n = graph[0].length;

        int time = findMinTimeBFS(graph, m, n);
        if(time == -1)
            System.out.println("All oranges cannot rot");
        System.out.println("Time taken to rot all oranges :"+ time);
    }

    public static int findMinTimeBFS(int[][] graph, int m, int n)
    {
        Queue<Node> queue = new LinkedList<>();
        int time =0;

        //add all the cells with rotten oranges to the queue
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j] == 2)
                    queue.add(new Node(i , j));
            }
        }

        // Separate these rotten oranges from the oranges
        // which will rotten due the oranges in first time
        // frame using delimiter which is (-1, -1)
        queue.add(new Node(-1, -1));

        while(!queue.isEmpty())
        {
            // This flag is used to determine whether even a
            // single fresh orange gets rotten due to rotten
            // oranges in the current time frame so we can
            // increase the count of the required time.
            boolean flag = false;

            // Process all the rotten oranges in current
            // time frame.
            while(!isDelimiter(queue.peek()))
            {
                Node curNode = queue.remove();
                int row = curNode.x;
                int col = curNode.y;

                if(isValid(graph, row + 1, col, m, n)){
                    if(!flag){
                        time++;
                        flag = true;
                    }
                    graph[row+1][col] = 2;
                    queue.add(new Node(row+1, col));
                }

                if(isValid(graph, row, col + 1, m, n)){
                    if(!flag){
                        time++;
                        flag = true;
                    }
                    graph[row][col+1] = 2;
                    queue.add(new Node(row, col + 1));
                }

                if(isValid(graph, row - 1, col, m, n)){
                    if(!flag){
                        time++;
                        flag = true;
                    }
                    graph[row-1][col] = 2;
                    queue.add(new Node(row-1, col));
                }

                if(isValid(graph, row, col-1, m, n)){
                    if(!flag){
                        time++;
                        flag = true;
                    }
                    graph[row][col-1] = 2;
                    queue.add(new Node(row, col-1));
                }
            }
            // Pop the delimite
            queue.remove();

            // If oranges were rotten in current frame than
            // separate the rotten oranges using delimiter
            // for the next frame for processing.
            if(!queue.isEmpty())
                queue.add(new Node(-1, -1));
        }

        // Return -1 if all arranges could not rot,
        // otherwise ans
        return checkIfAnyFreshOrange(graph, m, n) ? -1 : time;
    }

    public static boolean isValid(int[][] graph, int row, int col, int m, int n)
    {
        return row>=0 && row<m
                && col>=0 && col<n
                && graph[row][col] == 1;
    }

    public static boolean isDelimiter(Node node){
        return node.x == -1 && node.y == -1;
    }

    public static boolean checkIfAnyFreshOrange(int[][] graph, int m, int n)
    {
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j] == 1)
                    return true;
            }
        }
        return false;
    }
}
