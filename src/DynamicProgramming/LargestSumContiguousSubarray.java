package DynamicProgramming;

public class LargestSumContiguousSubarray {
    public static void main(String[] args) {
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };

        System.out.println("Max sum : " + KadaneAlgorithm(arr));
    }

    public static int KadaneAlgorithm(int[] arr)
    {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for(int i=0;i<arr.length;i++)
        {
            max_ending_here = max_ending_here + arr[i];
            if(max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if(max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    //Time Complexity: O(N)
    //Auxiliary Space: O(1)

    // The above code doesn't handle the condition when all array elements are negative
    // eg - [-1, -2, -3, -4] this will return 0 as the ans, when output should be -1
   // below code will handle that condition
    public static int findMaxSubarraySum(int[] nums) {
        // Write your code here...

        int maxEndingHere = 0;
        int maxSoFar = 0;
        int maxValue = Integer.MIN_VALUE; // will keep track of the max value incase of all negative elements, which we will return
        boolean isZeroPresent = false;
        for (int i = 0; i < nums.length; i++) {
            maxEndingHere += nums[i];
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
            if (nums[i] == 0 && !isZeroPresent) isZeroPresent = true;
            maxValue = Math.max(nums[i], maxValue);
        }

        if (maxSoFar == 0) { // in-case the sum is 0 when all negative elements are present, we check if any 0's are present
            if (isZeroPresent) return 0; // if present we return 0 as the ans
            else return maxValue; // else we return the largest negative element since 0 is not present
        }
        return maxSoFar; // else we return the sum computed
    }

    //Time Complexity: O(N)
    //Auxiliary Space: O(1)
}
