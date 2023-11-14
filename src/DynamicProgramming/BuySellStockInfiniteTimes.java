package DynamicProgramming;

public class BuySellStockInfiniteTimes {
    public static void main(String[] args) {
        int[] arr = {5,2,7,3,6,1,2,4};

        System.out.println("Max profit when stock is sold infinite times : " + maxProfit(arr));
    }

    public static int maxProfit(int[] arr)
    {
        int maxProfit = 0;
        for(int i=1; i<arr.length; i++)
        {
            if(arr[i] > arr[i-1])
                maxProfit = maxProfit + (arr[i]-arr[i-1]);
        }
        return maxProfit;
    }
}
