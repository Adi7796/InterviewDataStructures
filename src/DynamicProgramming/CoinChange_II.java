package DynamicProgramming;

/*
You are given an integer array coins representing coins of different
denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount.
If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1
 */
public class CoinChange_II {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;

        System.out.println(change(amount, coins));
    }
    public static int change(int amount, int[] coins) {
        int n = coins.length;
        // int[][] dp = new int[n][amount+1];
        // for(int[] row : dp)
        // {
        //     Arrays.fill(row, -1);
        // }
        //return findCombinations(n-1, amount, coins, n, dp);
        return findCombinationsTabulation(amount, coins, n);
    }

    private static int findCombinations(int ind, int amount, int[] coins, int n, int[][] dp)
    {
        if(ind == 0)
        {
            if(amount % coins[0] == 0) return 1;
            else return 0;
        }
        if(dp[ind][amount] != -1)
            return dp[ind][amount];

        int take = 0;
        int notTake = findCombinations(ind -1, amount, coins, n, dp);

        if(coins[ind] <= amount)
        {
            take = findCombinations(ind, amount - coins[ind], coins, n, dp);
        }
        return dp[ind][amount] = take + notTake;
    }

    private static int findCombinationsTabulation(int amount,  int[] coins, int n)
    {
        int[][] dp = new int[n][amount+1];

        for(int i = 0; i<= amount; i++)
        {
            if(i % coins[0] == 0) dp[0][i] = 1;
        }

        for(int index = 1; index < n; index++)
        {
            for(int a = 0; a <= amount; a++)
            {
                int take = 0;
                int notTake = dp[index-1][a];
                if(coins[index] <= a)
                {
                    take = dp[index][a - coins[index]];
                }
                dp[index][a] = take + notTake;
            }
        }
        return dp[n-1][amount];
    }
}
