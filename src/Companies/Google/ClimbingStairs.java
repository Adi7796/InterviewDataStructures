package Companies.Google;

/*
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 2 or 3 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 10;

        int[] dp = new int[n+1];
        dp[0] =1 ;

        for(int i=1;i<=n;i++)
        {
            if(i == 1) dp[i] = dp[i-1];
            else if (i==2) dp[i] = dp[i-1] + dp[i-2];
            else{
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }

        System.out.println("Total no of ways : " + dp[n]);
        System.out.println("Total no of ways using recursion : " + findWaysRecursion(n));
        System.out.println("Total no of ways using memoization : " + memoization(new int[n+1], n));
    }

    public static int findWaysRecursion(int n)
    {
        if(n==0) return 1;
        else if(n<0) return 0;

        return findWaysRecursion(n-1) + findWaysRecursion(n-2) + findWaysRecursion(n-3);
    }

    public static int memoization(int[] dp, int n)
    {
        if(n==0) return 1;
        else if(n<0) return 0;

        else if(dp[n] > 0) return dp[n];

        return memoization(dp, n-1) + memoization(dp, n-2) + memoization(dp, n-3);
    }
}
