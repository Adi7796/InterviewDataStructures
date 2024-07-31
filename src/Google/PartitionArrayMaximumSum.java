package Google;

import java.util.Arrays;

public class PartitionArrayMaximumSum {
    public static void main(String[] args) {
        //int[] arr = {1,4,1,5,7,3,6,1,9,9,3};
        int[] arr = {1,15,7,9,2,5,10};
        int k = 3;

        System.out.println();
        System.out.println("Max sum : " + maxSumAfterPartitioning(arr, k));
    }

    public static int maxSumAfterPartitioning(int[] arr, int k)
    {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int sum = 0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<k;i++)
        {
            max = Math.max(max, arr[i]);
        }
        sum = k*max;
        for(int i=0; i<k; i++)
        {
            dp[i] = max;
        }
        for(int i=1;i<n;i++)
        {
            int max_subarray = Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++)
            {
                if(j<n)
                    max_subarray = Math.max(max_subarray, arr[j]);
            }
            int includingLastIndexInCurrentSum = 0;
            int excludingLastIndexInCurrentSum = 0;
            includingLastIndexInCurrentSum = arr[i-1] + (k*max_subarray);
            int lastIndexSubArray = i+k-1;

            if(lastIndexSubArray<n)
                excludingLastIndexInCurrentSum = (k*max_subarray) + arr[lastIndexSubArray];
            if(includingLastIndexInCurrentSum > excludingLastIndexInCurrentSum && lastIndexSubArray < n)
            {
                dp[i-1] = arr[i-1];
                dp[lastIndexSubArray] = max_subarray;
            }
            else if(includingLastIndexInCurrentSum < excludingLastIndexInCurrentSum && lastIndexSubArray < n)
            {
                dp[lastIndexSubArray] = arr[lastIndexSubArray];
            }
            if(lastIndexSubArray < n)
                sum = sum + dp[lastIndexSubArray];
            if(lastIndexSubArray == n-1) break;
        }

        for(int i :dp)
        {
            System.out.print(i + " ");
        }


        return sum;
    }
}
