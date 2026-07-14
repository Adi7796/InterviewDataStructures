package DynamicProgramming;

/*
Given a rod of length ‘N’ units.
The rod can be cut into different sizes and each size has a cost associated with it.
Determine the maximum cost obtained by cutting the rod and selling its pieces.

Note:
1. The sizes will range from 1 to ‘N’ and will be integers.

2. The sum of the pieces cut should be equal to ‘N’.

3. Consider 1-based indexing.

Eg -
5
2 5 7 8 10

All possible partitions are:
1,1,1,1,1           max_cost=(2+2+2+2+2)=10
1,1,1,2             max_cost=(2+2+2+5)=11
1,1,3               max_cost=(2+2+7)=11
1,4                 max_cost=(2+8)=10
5                   max_cost=(10)=10
2,3                 max_cost=(5+7)=12
1,2,2               max _cost=(1+5+5)=12

Clearly, if we cut the rod into lengths 1,2,2, or 2,3, we get the maximum cost which is 12.
 */
public class RodCutting {
    public static void main(String[] args) {
        int[] price = {2, 5, 7, 8, 10};
        System.out.println(cutRod(price));
    }
    public static int cutRod(int[] price) {
        // code here
        int N = price.length;

        // int[][] dp = new int[N][N+1];
        // for(int i = 0; i<N; i++)
        // {
        //     Arrays.fill(dp[i], -1);
        // }
        // return recurse(price, N, N-1);
        // return memoization(price, N, N-1, dp);
        return tabulation(price, N);
    }


    private static int recurse(int[] price, int N, int ind)
    {
        int rodLen = ind + 1;
        if(ind == 0)
        {
            return price[0] * (N/rodLen);
        }

        int take = Integer.MIN_VALUE;
        if(rodLen <= N)
        {
            take = price[ind] + recurse(price, N - rodLen, ind);
        }

        int notTake = recurse(price, N, ind - 1);

        return Math.max(take, notTake);
    }

    private static int memoization(int[] price, int N, int ind, int[][] dp)
    {
        int rodLen = ind + 1;
        if(ind == 0)
        {
            return price[0] * (N/rodLen);
        }

        if(dp[ind][N] != -1) return dp[ind][N];
        int take = Integer.MIN_VALUE;
        if(rodLen <= N)
        {
            take = price[ind] + memoization(price, N - rodLen, ind, dp);
        }

        int notTake = memoization(price, N, ind - 1, dp);

        return dp[ind][N] = Math.max(take, notTake);
    }

    private static int tabulation(int[] price, int N)
    {
        int[][] dp = new int[N][N+1];
        for(int i=0; i<=N; i++)
        {
            dp[0][i] = price[0] * (i);
        }
        for(int i=1; i<N; i++)
        {
            for(int j=0; j<=N; j++)
            {
                int rodLen = i + 1;
                int take = Integer.MIN_VALUE;
                if(rodLen <= j)
                {
                    take = price[i] + dp[i][j - rodLen];
                }
                int notTake = dp[i-1][j];
                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[N-1][N];
    }
}
