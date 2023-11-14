package DynamicProgramming;

public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100, 4, 5};

        System.out.println("The maximum sum increasing subsequence is :"+ findMaximumSum(arr));
    }

    public static int findMaximumSum(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
        }
        int max_result =0;

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i] > arr[j] && dp[i] < dp[j] + arr[i]){
                    dp[i] = dp[j] + arr[i];
                }
                max_result = Math.max(max_result, dp[i]);
            }
        }

        return max_result;
    }
}
