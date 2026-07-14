package DynamicProgramming;

import java.util.Arrays;

public class NinjaTraining {

    public int maximumPoints(int arr[][]) {
        // code here
        int n = arr.length;

        int[][] dp = new int[n][3];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        //return recurse(arr, n-1, 3);
        return memoisation(arr, n-1, 3, dp);
    }

    private int memoisation(int[][] arr, int r, int last, int[][] dp)
    {
        if(r == 0){
            int maxi = 0;

            for(int i = 0; i < 3; i++)
            {
                if(i != last){
                    maxi = Math.max(maxi, arr[0][i]);
                    dp[r][i] = maxi;
                }
            }
            return maxi;
        }

        int maxi = 0;
        for(int i = 0; i < 3; i++) {
            if(i != last) {
                if(dp[r][i] != -1) return dp[r][i];
                int point = arr[r][i] + memoisation(arr, r-1, i, dp);
                maxi = Math.max(point, maxi);
                dp[r][i] = maxi;
            }
        }

        return maxi;
    }

}
