package Backtracking;

import java.util.Arrays;

public class RatMaze {
    public static void main(String[] args) {
        RatMaze ratMaze = new RatMaze();
        int[][] maze = {{1,0,0,0},
                        {1,1,0,1},
                        {0,1,0,1},
                        {1,1,1,1}};

        int N = maze.length;
        ratMaze.solveRateMaze(maze, N);
    }

    public void solveRateMaze(int [][] maze, int N)
    {
        int[][] sol = new int[N][N];

        if(!solveRateMazeUtil(maze, sol, N, 0, 0))
            System.out.println("No path exist to reach destination");
        else {
            System.out.println("Path exists to reach the destination");
            printSolution(sol);
        }
    }

    public boolean solveRateMazeUtil(int[][] maze, int[][] sol, int N, int x, int y)
    {
        if(x == N-1 && y== N-1
            && maze[x][y] == 1)
        {
            sol[x][y] = 1;
            return true;
        }

        if(isSafe(maze,x,y,N))
        {
            // if this cell has been visited already
           if(sol[x][y] == 1)
               return false;

           sol[x][y] = 1;

           if(solveRateMazeUtil(maze, sol, N, x + 1, y))
               return true;

           if(solveRateMazeUtil(maze, sol, N, x, y + 1))
               return true;

           sol[x][y] = 0;
           return false;
        }
        return false;
    }

    public boolean isSafe(int[][] maze, int x, int y, int N)
    {
        return x >= 0 && x < N && y >= 0 && y < N
                && maze[x][y] == 1;
    }

    public void printSolution(int[][] sol){
        for(int i=0;i<sol.length; i++)
        {
            for(int j=0;j<sol.length; j++)
            {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*
Time Complexity: O(2^(m*n)), because on every cell we have to try 2 different directions.
Auxiliary Space: O(m*n), Maximum Depth of the recursion tree(auxiliary space).
 */
