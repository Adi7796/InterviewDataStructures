package DynamicProgramming;

import java.util.Arrays;

public class BuySellStockAtMostOneTime {
    public static void main(String[] args) {
        int[] arr = {3,1,4,8,7,2,5};
        System.out.println("Max profit using extra space of array : "+ maxProfitUsingSpace(arr));
        System.out.println("Max profit using variable : "+ maxProfitUsingVariable(arr));
    }

    public static int maxProfitUsingSpace(int[] arr)
    {
        int[] profit = new int[arr.length];
        int n = arr.length;
        int maxProfit = Integer.MIN_VALUE;

        profit[n-1] = arr[n-1];

        for(int i=n-2; i>=0;i--)
        // creating a profit array which stores value of the highest value towards the right of the current element
            // this value denotes the highest return you can get on the stock if sold
        {
            profit[i] = Math.max(arr[i], profit[i+1]);
        }
        System.out.print("Max value towards the right of the current element : ");
        for(int k : profit)
            System.out.print(k + " ");

        System.out.println();
        for(int i=0;i<n;i++){
            maxProfit = Math.max(maxProfit, profit[i] - arr[i]);
        }

        return maxProfit;
    }


    public static int maxProfitUsingVariable(int[] arr)
    {

        // Keeping track of the min value seen so far on which the stock could be bought
        int max_profit = Integer.MIN_VALUE;
        int min_so_far = Integer.MAX_VALUE;
        int profit = 0;

        for(int i=0;i<arr.length; i++)
        {
            min_so_far = Math.min(arr[i], min_so_far);
            profit = arr[i] - min_so_far;
            max_profit = Math.max(max_profit, profit);
        }

        return max_profit;
    }
}
