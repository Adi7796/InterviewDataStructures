package Companies.Uber;

import java.util.Deque;
import java.util.LinkedList;

public class LongestContiguousSubArrayWithAbsoluteDifferenceEqualOrLessThanK {
    public static void main(String[] args) {
        int[] nums = {10,1,2,4,7,2};
        int limit = 5;

        System.out.println(longestSubarray(nums, limit));

    }

    public static int longestSubarray(int[] nums, int limit) {

        Deque<Integer> increasingDeq = new LinkedList<>();
        Deque<Integer> decreasingDeq = new LinkedList<>();

        int start = 0, end = 0;
        int maxLength = Integer.MIN_VALUE;

        while(end < nums.length)
        {
            int x = nums[end];

            // while we keep seeing smaller numbers than the current number we need to poll the end of the queue
            while(!decreasingDeq.isEmpty() && x >= nums[decreasingDeq.peekLast()]) { decreasingDeq.pollLast(); }

            decreasingDeq.offerLast(end);

            // while we keep seeing greater numbers than the current number, we need to poll the end of the queue
            while(!increasingDeq.isEmpty() && x <= nums[increasingDeq.peekLast()]) { increasingDeq.pollLast(); }

            increasingDeq.offerLast(end);


            int maxElement = nums[decreasingDeq.peekFirst()];
            int minElement = nums[increasingDeq.peekFirst()];

            if(maxElement - minElement > limit)
            {
                start++;
                if(start > increasingDeq.peekFirst()) { increasingDeq.pollFirst(); }
                if(start > decreasingDeq.peekFirst()) { decreasingDeq.pollFirst(); }
            }
            else{
                maxLength = Math.max(maxLength, end - start + 1);
                end++;
            }
        }

        return maxLength;
    }
}
