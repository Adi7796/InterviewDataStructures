package DynamicProgramming;

public class LargestSumContiguousSubarray_PrintArr {
    public static void main(String[] args) {
        //int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //int[] arr = {8, -7, -3, 5, 6, -2, 3, -4, 2};
        //int[] arr = {-1, -2 -3, -4};
        int[] arr = {0, 0, 0, 0};
        int[] ans = findMaxSubarraySum(arr);
        for(int i : ans)
        {
            System.out.print(i + " ");
        }
    }

    // The above code doesn't handle the condition when all array elements are negative
    // eg - [-1, -2, -3, -4] this will return 0 as the ans, when output should be -1
   // below code will handle that condition
    public static int[] findMaxSubarraySum(int[] nums) {
        // Write your code here...

        int maxEndingHere = 0;
        int maxSoFar = 0;
        int start_index = 0;
        int end_index = 0;

        int maxValue = Integer.MIN_VALUE; // will keep track of the max value in-case of all negative elements, which we will return
        boolean isZeroPresent = false;
        for (int i = 0; i < nums.length; i++) {
            maxEndingHere += nums[i];
            if(maxEndingHere > maxSoFar)
            {
                maxSoFar = maxEndingHere;
                end_index = i;
            }
            if (maxEndingHere < nums[i]) {
                maxEndingHere = 0;
                start_index = i+1;
            }
            if (nums[i] == 0 && !isZeroPresent) isZeroPresent = true;
            maxValue = Math.max(nums[i], maxValue);
        }

//        if (maxSoFar == 0) { // in-case the sum is 0 when all negative elements are present, we check if any 0's are present
//            if (isZeroPresent) return 0; // if present we return 0 as the ans
//            else return maxValue; // else we return the largest negative element since 0 is not present
//        }

        int n = end_index - start_index + 1;
        int[] ans = new int[n];
        int i = 0;
        for(int j = start_index; j <= end_index; j++)
        {
            ans[i] = nums[j];
            i++;
        }
        return ans; // else we return the sum computed
    }

    //Time Complexity: O(N)
    //Auxiliary Space: O(1)
}
