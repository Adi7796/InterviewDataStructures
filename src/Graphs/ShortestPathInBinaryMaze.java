package Graphs;

import java.util.LinkedList;
import java.util.Queue;

//TimeComplexity : O(M*N)
//SpaceComplexity : O(M*N)
public class ShortestPathInBinaryMaze {

    static class  Node{
        int x;
        int y;

        Node(int x, int y)
        {
            this.x=x;
            this.y=y;
        }
    }

    static class QueueNode{
        Node node;
        int dist;

        public QueueNode(Node node, int dist){
            this.node=node;
            this.dist=dist;
        }
    }

    public static void main(String[] args)
    {
        int[][] matrix = {{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                          { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                          { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                          { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                          { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                          { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                          { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                          { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                          { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};

        Node src = new Node(0,0);
        Node dest = new Node(3,4);

        System.out.println("Shortest dist to dest from src :" + shortestPathBFS(matrix, src, dest));
    }

    public static int shortestPathBFS(int[][] matrix, Node src, Node dest)
    {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        boolean[][] visited = new boolean[rowLength][colLength];

        // initialise arrays to mark all the possible directions in which we will check - 4 directions
        // (1,0), (0,1), (-1,0), (0,-1)
        int[] ROW = new int[] {1, 0, -1, 0};
        int[] COL = new int[] {0, 1, 0, -1};

        for(int i=0;i<rowLength; i++) {
            for(int j=0; j<colLength; j++) {
                visited[i][j]=false;
            }
        }

        // if either the src or dest cant be reached return -1
        if(matrix[src.x][src.y] !=1 || matrix[dest.x][dest.y] != 1)
            return -1;


        //else enqueue the src node and call BFS on its neighbours
        Queue<QueueNode> queue = new LinkedList<>();
        visited[src.x][src.y] = true;
        queue.add(new QueueNode(new Node(src.x, src.y), 0));

        while(!queue.isEmpty())
        {
            QueueNode cell = queue.remove();
            int curRow = cell.node.x;
            int curCol = cell.node.y;

            //if the current cell is the same as the dest cell, return the dist
            if(dest.x == curRow && dest.y == curCol)
                return cell.dist;

            for(int k=0;k<4; k++)
            {
                //check if the new cell which is the neighbour of the current node is valid
                // if valid, create a new node for the neighbour and add to the initial queue
                // use the direction arrays ROW and COL to go in 4 directions to check for immediate neighbours
                if(isValid(matrix, curRow + ROW[k], curCol + COL[k], rowLength, colLength, visited)){
                    QueueNode newNode = new QueueNode(new Node(curRow + ROW[k], curCol + COL[k]), cell.dist+1);
                    queue.add(newNode);
                }
            }
        }
        return -1;

    }

    public static boolean isValid(int[][] matrix, int row, int col, int rowLength, int colLength, boolean[][] visited)
    {
        // a cell is valid if its within bounds of the matrix
        // and the cell is unvisited yet
        // and has a value 1
        return row>=0 && row<rowLength
                && col>=0 && col<colLength
                && !visited[row][col]
                && matrix[row][col] == 1;
    }
}
