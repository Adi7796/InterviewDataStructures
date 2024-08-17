package Companies.Amazon;

import java.util.Arrays;

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0

 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {

        int n = coins.length;

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i=1;i<= amount; i++)
        {
            for(int j = 0; j< n; j++)
            {
                if(coins[j] <= i)
                {
                    int remainingAmount = i - coins[j];
                    int sub_result = dp[remainingAmount];

                    if(sub_result != Integer.MAX_VALUE && sub_result + 1 < dp[i])
                    {
                        dp[i] = sub_result + 1;
                    }
                }
            }
        }

        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
}
