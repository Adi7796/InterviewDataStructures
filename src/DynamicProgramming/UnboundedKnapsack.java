package DynamicProgramming;

import java.util.Arrays;

/*
Given a knapsack weight, say capacity and a set of n items with certain value
vali and weight wti, The task is to fill the knapsack in such a way that we can get
the maximum profit. This is different from the classical Knapsack problem,
here we are allowed to use an unlimited number of instances of an item.

Examples:

Input: capacity = 100, val[]  = [1, 30], wt[] = [1, 50]
Output: 100
Explanation: There are many ways to fill knapsack.
1) 2 instances of 50 unit weight item.
2) 100 instances of 1 unit weight item.
3) 1 instance of 50 unit weight item and 50 instances of 1 unit weight items.
We get maximum value with option 2.

Input: capacity = 8, val[] = [10, 40, 50, 70], wt[]  = [1, 3, 4, 5]
Output : 110
Explanation: We get maximum value with one unit of weight 5 and one unit of weight 3.
 */
public class UnboundedKnapsack {
    public static void main(String[] args) {
        int val[] = {6, 1, 7, 7}, wt[] = {1, 3, 4, 5}, capacity = 8;
        int n = val.length;
        int[][] dp = new int[n][capacity+1];
        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }

        System.out.println(knapsackUtilMemoization(n-1, val, wt, capacity, dp));
        System.out.println(knapsackUtilTabulation(val, wt, capacity));
    }

    private static int knapsackUtilMemoization(int index, int val[], int wt[], int capacity, int[][] dp)
    {
        /**
         * if we reach the last index after starting from n
         * and we have a remaining capacity, we can pick the last items capacity/wt[0] number of times
         * and we multiply the value of that item to the number of times
         */
        if(index == 0)
        {
            return ((int)(capacity/wt[0])) * val[0];
        }

        if(dp[index][capacity] != -1)
            return dp[index][capacity];
        int take = Integer.MIN_VALUE;

        // if we dont take, we dont add any value and go to the next index
        int notTake = 0 + knapsackUtilMemoization(index-1, val, wt, capacity, dp);
        if(wt[index] <= capacity)
        {
            // if we take, we add the value of that item and subtract the capacity and stay at the same index
            // as we have infinite supply of that item
            take = val[index] + knapsackUtilMemoization(index, val, wt, capacity - wt[index], dp);
        }

        return dp[index][capacity] = Math.max(take, notTake);
    }

    private static int knapsackUtilTabulation(int val[], int wt[], int capacity)
    {
        int n = wt.length;
        int[][] dp = new int[n][capacity+1];
        for(int[] row : dp)
        {
            Arrays.fill(row, 0);
        }

        for(int w = 0; w<= capacity; w++)
        {
            dp[0][w] = ((int)(w/wt[0])) * val[0];
        }

        for(int index = 1; index < n; index++)
        {
            for(int W = 0; W <= capacity; W++)
            {
                int take = Integer.MIN_VALUE;
                int notTake = 0 + dp[index-1][W];
                if(wt[index] <= W)
                {
                    take = val[index] + dp[index][W-wt[index]];
                }
                dp[index][W] = Math.max(take, notTake);
            }
        }

        return dp[n-1][capacity];
    }
}
