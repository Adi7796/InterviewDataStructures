package BinarySearch;

/*
Given an array of integers nums and an integer threshold,
we will choose a positive integer divisor, divide all the array by it,
and sum the division's result. Find the smallest divisor such that the
result mentioned above is less than or equal to threshold.

Each result of the division is rounded to the nearest integer greater
than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

The test cases are generated so that there will be an answer.
Example 1:

Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).
Example 2:

Input: nums = [44,22,33,11,1], threshold = 5
Output: 44
 */
public class SmallestDivisorGivenAThreshold {
    public static void main(String[] args) {
        int[] nums = {1,2,5,9};
        int threshold = 6;

        System.out.println(smallestDivisor(nums, threshold));
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i<nums.length; i++)
        {
            max = Math.max(nums[i], max);
        }

        int low = 1;
        int high = max;
        int ans = -1;

        while(low <= high)
        {
            int mid = (low+high)/2;
            if(sum(nums, mid) <= threshold)
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

    private static int sum(int[] arr, int num)
    {
        int ans = 0;
        for(int i = 0; i < arr.length; i++)
        {
            ans += Math.ceil((double)arr[i]/num);
        }
        return ans;
    }
}
