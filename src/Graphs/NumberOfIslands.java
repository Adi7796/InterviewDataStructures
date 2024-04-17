package Graphs;

import java.util.ArrayList;
public class NumberOfIslands {

    static int ROW = 5;
    static int COL = 5;
    public static void main(String[] args)
    {
        int[][] graph = new int[][] { { 1, 1, 0, 0, 0 },
                                      { 0, 1, 0, 0, 1 },
                                      { 1, 0, 0, 1, 1 },
                                      { 0, 0, 0, 0, 0 },
                                      { 1, 0, 1, 0, 1 } };

        boolean[][] visited = new boolean[ROW][COL];
        for(int i=0;i<ROW;i++){
            for(int j=0;j<COL;j++){
                visited[i][j]=false;
            }
        }

        System.out.println("No. of islands : "+ countIslands(graph,visited));
    }

    public static boolean isSafe(int[][] graph, int rowNum, int colNum, boolean[][] visited)
    {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return ( rowNum < ROW && rowNum >=0
        && colNum < COL && colNum >=0
        && graph[rowNum][colNum]==1 && !visited[rowNum][colNum] );
    }

    public static int countIslands(int[][] graph, boolean[][] visited)
    {
        // if a cell with value 1 is not visited yet
        // visit this cell and call dfs on this cell
        // since a new island is found, increment the count
        int count =0;
        for(int i=0; i<ROW; i++){
            for(int j=0; j < COL; j++){
                if(graph[i][j] == 1 && !visited[i][j]){
                   DFS(graph, i, j, visited);
                   count ++;
                }
            }
        }
        return count;
    }

    public static void DFS(int[][] graph, int row, int col, boolean[][] visited)
    {
        // These arrays are used to get row and column
        // numbers of 8 neighbors of a given cell
        int[] rowNum = new int[] {1, 1, 0, -1, -1, -1, 0, 1};
        int[] colNum = new int[] {0, 1, 1, 1, 0, -1, -1, -1};

        //Mark the visited cell as true
        visited[row][col] = true;

        // Recur for all connected neighbours
        for(int k=0; k<8; k++)
        {
            if(isSafe(graph, row + rowNum[k], col + colNum[k], visited))
                DFS(graph, row + rowNum[k], col + colNum[k], visited);
        }
    }
}
