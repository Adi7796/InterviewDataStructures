package DynamicProgramming;

import java.util.Arrays;

public class BuySellStockInfiniteTimes {
    public static void main(String[] args) {
        int[] arr = {5,2,7,3,6,1,2,4};

        System.out.println("Max profit when stock is sold infinite times : " + maxProfit(arr));
    }

    public static int maxProfit(int[] arr)
    {
        int maxProfit = 0;
        for(int i=1; i<arr.length; i++)
        {
            if(arr[i] > arr[i-1])
                maxProfit = maxProfit + (arr[i]-arr[i-1]);
        }
        return maxProfit;
    }

    public int maxProfit1(int[] prices) {
        // code here
        // buy = 1 means we can buy at index ind
        // buy = 0 means we can't buy at index ind
        int[][] dp = new int[prices.length][2];
        for(int i=0; i<prices.length; i++)
        {
            Arrays.fill(dp[i], -1);
        }
        //return recurse(prices, 0, 1);
        //return memoization(prices, 0, 1, dp);
        //return tabulation(prices);
        return tabulationSpaceOptim(prices);
    }

    private static int recurse(int[] prices, int ind, int buy)
    {
        if(ind == prices.length) return 0;
        int profit = 0;
        if(buy == 1){
            int bought = -prices[ind] + recurse(prices, ind + 1, 0);
            int notBought = 0 + recurse(prices, ind + 1, 1);
            profit = Math.max(bought, notBought);
        }

        else{
            int sold = prices[ind] + recurse(prices, ind+1, 1);
            int notSold = 0 + recurse(prices, ind+1, 0);
            profit = Math.max(sold, notSold);
        }

        return profit;
    }

    private static int memoization(int[] prices, int ind, int buy, int[][] dp)
    {
        if(ind == prices.length) return 0;
        int profit = 0;

        if(dp[ind][buy] != -1) return dp[ind][buy];
        if(buy == 1){
            int bought = -prices[ind] + memoization(prices, ind + 1, 0, dp);
            int notBought = 0 + memoization(prices, ind + 1, 1, dp);
            profit = Math.max(bought, notBought);
        }

        else{
            int sold = prices[ind] + memoization(prices, ind+1, 1, dp);
            int notSold = 0 + memoization(prices, ind+1, 0, dp);
            profit = Math.max(sold, notSold);
        }

        return dp[ind][buy] = profit;
    }

    private static int tabulation(int[] prices)
    {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        int profit = 0;
        //dp[n][0] = dp[n][0] = 0;
        for(int i=n;i>=0;i--)
        {
            for(int j=0; j<2; j++)
            {
                if(i == n) dp[n][j] = 0;
                else{
                    if(j == 1)
                    {
                        int bought = -prices[i] + dp[i + 1][0];
                        int notBought = 0 + dp[i + 1][1];
                        profit = Math.max(bought, notBought);
                    }
                    else{
                        int sold = prices[i] + dp[i+1][1];
                        int notSold = 0 + dp[i+1][0];
                        profit = Math.max(sold, notSold);
                    }
                    dp[i][j] = profit;
                }
            }
        }

        return dp[0][1];
    }

    private static int tabulationSpaceOptim(int[] prices)
    {
        int n = prices.length;
        int[] ahead = new int[2];
        int[] dp = new int[2];
        int profit = 0;
        ahead[0] = ahead[1] = 0;
        for(int i=n-1;i>=0;i--)
        {
            for(int j=0; j<2; j++)
            {
                if(j == 1)
                {
                    int bought = -prices[i] + ahead[0];
                    int notBought = 0 + ahead[1];
                    profit = Math.max(bought, notBought);
                }
                else{
                    int sold = prices[i] + ahead[1];
                    int notSold = 0 + ahead[0];
                    profit = Math.max(sold, notSold);
                }
                dp[j] = profit;
                ahead = dp;
            }
        }

        return ahead[1];
    }
}
