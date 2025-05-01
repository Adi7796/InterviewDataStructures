package Companies.Google;

/*
In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell,
0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position, you can walk one step to the left, right, up, or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.
 */
public class PathToMaximumGold {
    public static void main(String[] args) {
//        int[][] grid = {{0,6,0},
//                        {5,8,7},
//                        {0,9,0}};

        int[][] grid = {{1,0,7},
                        {2,0,6},
                        {3,4,5},
                        {0,3,0},
                        {9,0,20}};

        PathToMaximumGold obj = new PathToMaximumGold();
        int ans = Integer.MIN_VALUE;
        int m = grid.length;;
        int n = grid[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                ans = Math.max(ans, obj.getMaximumGold(grid, i, j, 0));
            }
        }
        System.out.println("Maximum gold : " + ans);
    }

    public int getMaximumGold(int[][] grid, int i, int j, int ans)
    {

        if(!isValid(grid, i, j))
        {
            return 0;
        }
        int value = grid[i][j];
        ans += grid[i][j];
        grid[i][j] = 0;

        int top = getMaximumGold(grid, i-1, j, ans);

        int bottom = getMaximumGold(grid, i+1, j, ans);

        int left = getMaximumGold(grid, i, j-1, ans);

        int right = getMaximumGold(grid, i, j+1, ans);

        grid[i][j] = value;

        return Math.max(ans, Math.max(top,Math.max(bottom, Math.max(left, right))));
    }

    public boolean isValid(int[][] grid, int i, int j)
    {
        if(i>=0 && i< grid.length && j>=0 && j<grid[0].length && grid[i][j] != 0)
            return true;
        return false;
    }
}
