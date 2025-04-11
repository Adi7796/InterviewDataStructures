package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
You are given an m x n matrix board containing letters 'X' and 'O',
capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells
if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
To capture a surrounded region, replace all 'O's with 'X's
in-place within the original board. You do not need to return anything.

 */
public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        SurroundedRegions obj = new SurroundedRegions();

        obj.solve(board);
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    class Node
    {
        int x;
        int y;

        Node(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board)
    {
        Queue<Node> queue = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(i == 0 || i == m-1 || j == 0 || j == n-1)
                {
                    if(board[i][j] == 'O')
                    {
                        queue.offer(new Node(i, j));
                    }
                }
            }
        }

        int[] row = {1, 0, -1, 0};
        int[] col = {0, 1, 0, -1};
        while(!queue.isEmpty())
        {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            board[x][y] = '!';
            for(int k = 0; k<4; k++)
            {
                int nrow = x + row[k];
                int ncol = y + col[k];

                if(nrow>=0 && nrow < m && ncol >= 0 && ncol<n
                        && board[nrow][ncol] == 'O')
                {
                    queue.offer(new Node(nrow, ncol));
                }
            }
        }

        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(board[i][j] == 'O')
                {
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '!')
                {
                    board[i][j] = 'O';
                }

            }
        }
    }
}

/*
Time Complexity: O(N) where N is the number of cells in the board
 */
