package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1, 1, 3, 3};
        int[] arr1 = {-1, 0, 1, 2, 3, 4, 1, 0, 1};
        int k = 6;

        System.out.println("Maximum length of subarray with all positives and no 0 with sum k: " + findMaxLengthPositives(arr, k));
        // ans - 1, 1, 1, 3
        System.out.println("Maximum length of subarray with positives, negatives and zeroes with sum k: " + findMaxLengthNegatives(arr1, k));
        // ans - 0, 1, 2, 3
    }

    public static int findMaxLengthPositives(int[] arr, int k)
    {

        // this approach will not work if we have negatives and 0's in the array
        int left = 0, right = 0;
        int sum = arr[0];
        int maxLen = 0;
        int n = arr.length;

        // we keep moving right and trimming left if the sum crosses k
        while(right < n)
        {
            // trim left part of the subarray if current sum crosses k
            while(left <= right && sum > k)
            {
                sum -= arr[left];
                left++;
            }

            // if sum matches k, we compute the max len
            if(sum == k)
            {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // keep moving right until we are inside the boundary and keep on adding to the current sum
            right++;
            if(right < n)
            {
                sum += arr[right];
            }

        }
        return maxLen;
    }

    public static int findMaxLengthNegatives(int[] arr, int k)
    {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;

        for(int i=0; i<arr.length; i++)
        {
            // calculate prefix sum till i
            prefixSum += arr[i];

            // if the sum = k, update the maxLen:
            if(prefixSum == k)
            {
                maxLen = Math.max(maxLen, i+1);
            }

            // calculate the sum of remaining part i.e. x-k:
            int remaining = prefixSum - k;

            // Calculate the length and update maxLen:
            // if there exists  sum - k in the map
            // then that means the current pointer ends at a point where the
            // sum of some subarray is equal to k
            if(prefixSumMap.containsKey(remaining))
            {
                int len = i - prefixSumMap.get(remaining);
                maxLen = Math.max(len, maxLen);
            }

            // if the prefix sum already exists, we dont update the index
            // this is to handle 0 condition
            if(!prefixSumMap.containsKey(prefixSum))
            {
                prefixSumMap.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}
