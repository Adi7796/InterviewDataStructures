package Greedy;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int [] profit = {10, 15, 40};
        int[] weight = {1, 2, 3};
        int W = 6;

        int N = profit.length;
        System.out.println("Max Profit :"+ maxProfitKnapsack(profit, weight, W, N));
    }

    public static int maxProfitKnapsack(int[] profit, int[] weight, int W, int N)
    {
        int[][] dp = new int[N+1][W+1];

        for(int i=0;i<N+1; i++)
        {
            for(int w=0; w< W+1; w++)
            {
                if(i == 0 || w == 0)
                    dp[i][w] = 0;
                else if(weight[i-1] <= w)
                {
                    dp[i][w] = Math.max(dp[i-1][w], profit[i-1] + dp[i-1][w-weight[i-1]]);
                }
                else{
                    dp[i][w] = dp[i-1][w];
                }
            }
        }

        return dp[N][W];
    }
}
