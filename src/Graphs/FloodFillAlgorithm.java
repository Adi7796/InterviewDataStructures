package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/* Given a 2D screen arr[][] where each arr[i][j] is an integer representing
the color of that pixel, also given the location of a pixel (X, Y) and a color C,
the task is to replace the color of the given pixel and all the adjacent same-colored pixels with the given color.
 */

public class FloodFillAlgorithm {

    static class Cell{
        int x;
        int y;

        Cell(int x, int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args)
    {
        int[][] graph ={
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1}};

        int n = graph[0].length;

        int X=4, Y=4, newColor = 3;
        int prevColor = graph[X][Y];
        floodFillBFS(graph, X, Y, newColor, prevColor);

        for (int[] ints : graph) {
            for (int j = 0; j < n; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public static void floodFillBFS(int[][] graph, int X, int Y, int newColor, int prevColor)
    {
        Cell node = new Cell(X, Y);
        Queue<Cell> queue = new LinkedList<>();
        int[] ROW = new int[]{1, 0, -1, 0};
        int[] COL = new int[]{0, 1, -0, -1};

        queue.add(node);

        while(!queue.isEmpty())
        {
            Cell curCell = queue.remove();
            int row = curCell.x;
            int col = curCell.y;
            for(int k=0; k<4; k++){
                if(isValid(graph, row + ROW[k], col + COL[k], newColor, prevColor))
                {
                    graph[row+ROW[k]][col + COL[k]] = newColor;
                    queue.add(new Cell(row + ROW[k], col + COL[k]));
                }
            }
        }
    }

    public static boolean isValid(int[][] graph, int row, int col, int newColor, int prevColor)
    {
        return row>=0 && row<graph.length
                && col>=0 && col<graph[0].length
                && graph[row][col] == prevColor
                && graph[row][col] != newColor;
    }
}
