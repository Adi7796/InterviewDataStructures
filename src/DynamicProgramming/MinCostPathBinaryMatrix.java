package DynamicProgramming;

public class MinCostPathBinaryMatrix {

    public static void main(String[] args) {
        int cost[][]
                = { { 1, 2, 3 },
                    { 4, 8, 2 },
                    { 1, 5, 3 } };

        System.out.println("Min cost using recursion : " + minCostRecursion(cost, 2, 2));
        System.out.println("Min cost using DP : " + minCostDP(cost, 2, 2));
    }

    //Time Complexity: O((M * N)3)
    //Auxiliary Space: O(M + N), for recursive stack space
    public static int minCostRecursion(int[][] cost, int m, int n){
        if(m < 0 || n < 0 || m > cost.length || n > cost.length){
            return Integer.MAX_VALUE;
        }
        else if(m == 0 && n == 0)
            return cost[m][n];

        return cost[m][n] +
                Math.min(minCostRecursion(cost, m-1, n-1),
                        Math.min(minCostRecursion(cost ,m-1, n), minCostRecursion(cost, m, n-1)));
    }

    //Time Complexity: O(M * N)
    //Auxiliary Space: O(M * N)
    public static int minCostDP(int[][] cost, int m, int n)
    {
        int[][] dp = new int[cost.length][cost[0].length];
        dp[0][0] = cost[0][0];
        for(int i=0; i<cost.length; i++)
        {
            for(int j=0;j<cost[0].length;j++)
            {
                if(i==0 && j !=0){
                    dp[i][j] = cost[0][j] + dp[0][j-1];
                }
                else if(j==0 && i!=0){
                    dp[i][j] = cost[i][0] + dp[i-1][0];
                }
                else if (i>0 && j>0){
                    dp[i][j] = cost [i][j] + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }

        return dp[m][n];
    }
}
