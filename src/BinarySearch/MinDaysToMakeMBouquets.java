package BinarySearch;

/*
You are given an integer array bloomDay, an integer m and an integer k.

You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and
then can be used in exactly one bouquet.

Return the minimum number of days you need to wait to be able to make m bouquets from the garden.
If it is impossible to make m bouquets return -1.

Example 1:

Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
Output: 3
Explanation: Let us see what happened in the first three days. x means
flower bloomed and _ means flower did not bloom in the garden.
We need 3 bouquets each should contain 1 flower.
After day 1: [x, _, _, _, _]   // we can only make one bouquet.
After day 2: [x, _, _, _, x]   // we can only make two bouquets.
After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
Example 2:

Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
Output: -1
Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so
it is impossible to get the needed bouquets and we return -1.
 */
public class MinDaysToMakeMBouquets {

    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        int m = 3, k = 1;

        System.out.println(minDays(bloomDay, m, k));
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(n < m*k) return -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i<bloomDay.length; i++)
        {
            min = Math.min(bloomDay[i], min);
            max = Math.max(bloomDay[i], max);
        }

        int low = min, high = max;
        int ans = -1;

        while(low <= high)
        {
            int mid = (low+high)/2;
            if(isPossible(bloomDay, mid, m, k))
            {
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[] arr, int day, int m, int k)
    {
        int cnt = 0, noOfBouquets = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] <= day)
            {
                cnt++;
            }
            else{
                noOfBouquets += (cnt/k);
                cnt = 0;
            }
        }
        noOfBouquets += (cnt/k);
        return noOfBouquets >= m;
    }
}
