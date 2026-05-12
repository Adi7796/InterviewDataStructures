package Backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class RatMaze2 {

    public static void main(String[] args) {
        RatMaze2 obj = new RatMaze2();
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        ArrayList<String> pathList = obj.ratInMaze(maze);
        pathList.forEach(System.out::println);
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        int m = maze.length;
        int n = maze[0].length;

        int[][] sol = new int[m][n];

        boolean isPath = findPath(0, 0, m, n, maze, sol, ans, new StringBuilder(""));
        if(isPath)
        {
            Collections.sort(ans);
            return ans;
        }
        else return new ArrayList<String>();
    }

    public boolean findPath(int i, int j, int m, int n, int[][] maze, int[][] sol, ArrayList<String> ans, StringBuilder dir)
    {
        if(maze[m-1][n-1] == 0 || maze[m-1][n-1] == 0) return false;
        if(i == m-1 && j == n-1 && maze[i][j] == 1)
        {
            sol[i][j] = 1;
            ans.add(dir.toString());
            return true;
        }


        if(sol[i][j] == 1)
            return false;

        sol[i][j] = 1;
        boolean found = false;
        if(isSafe(i+1, j, m, n, maze)){
            dir.append("D");
            if(findPath(i+1, j, m, n, maze, sol, ans, dir)){
                found = true;
            }
            dir.deleteCharAt(dir.length() - 1);
        }
        if(isSafe(i, j+1, m, n, maze)){
            dir.append("R");
            if(findPath(i, j+1, m, n, maze, sol, ans, dir)){
                found = true;
            }
            dir.deleteCharAt(dir.length() - 1);
        }
        if(isSafe(i-1, j, m, n, maze)){
            dir.append("U");
            if(findPath(i-1, j, m, n, maze, sol, ans, dir)){
                found = true;
            }
            dir.deleteCharAt(dir.length() - 1);
        }
        if(isSafe(i, j-1, m, n, maze)){
            dir.append("L");
            if(findPath(i, j-1, m, n, maze, sol, ans, dir)){
                found = true;
            }
            dir.deleteCharAt(dir.length() - 1);
        }

        sol[i][j] = 0;
        return found;
    }

    public boolean isSafe(int i , int j, int m, int n, int[][] maze)
    {
        return i>=0 && i < m && j >= 0 && j < n && maze[i][j] == 1;
    }
}
