package DynamicProgramming;

import java.util.ArrayList;

/*
Given an integer array of coins[ ] of size N representing different types of denominations and an integer sum,
the task is to count the number of coins required to make a given value sum.
Note: Assume that you have an infinite supply of each type of coin.
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int N =3;
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        ArrayList<Integer> coinSet = new ArrayList<>();
        System.out.println("Minimum number of coins using recursion : " + findCountRec(coins, N, 4));
        for(ArrayList<Integer> list : ansList){
            System.out.println(list);
        }
        System.out.println("Minimum number of coins using DP : "+ findCountDP(coins, N, 5));
    }

    public static int findCountRec(int[] coins, int n, int sum)
    {
        if(n<=0 || sum < 0) {  // base case : if sum is negative or 0 or negative coins are left, we return
            return 0;
        }
        if(sum == 0)    // if sum == 0 we have found one combination.
        {
            return 1;
        }

        return findCountRec(coins, n, sum - coins[n-1])   // including nth coin
                + findCountRec(coins, n-1, sum);   // not including nth coin

    }

    public static int findCountDP(int[] coins, int n, int sum)
    {
        int[][] dp = new int[n+1][sum+1];

        dp[0][0] = 1;  // base case when sum and number of coins is 0, there is only 1 way by not selecting any coin

        for(int i=1;i<=n; i++)
        {
            for(int j=0;j<=sum; j++)
            {
                if(j < coins[i-1]){   // if the current sum is smaller than the current coin, take the value when this coins was not chosen
                    dp[i][j] = dp[i-1][j];
                }
                else if(j - coins[i-1] >=0)
                { // if the current sum is greater than the current coin, store the value
                    // by chosing this current coin and adding the value with the remaining sum
                    dp[i][j] = dp[i][j-coins[i-1]] + dp [i-1][j];
                }
            }
        }

        return dp[n][sum];
    }
}
