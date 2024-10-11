package Companies.Amazon;

/*
You are given a sorted array consisting of only integers where
every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
 */
public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {3,3,7,7,10,11,11};
        SingleElementInSortedArray obj = new SingleElementInSortedArray();

        System.out.println(obj.singleNonDuplicate(nums));
    }

    public int singleNonDuplicate ( int[] nums){
        if (nums.length == 1) return nums[0];
        else if (nums[0] != nums[1]) return nums[0];
        else if (nums[nums.length - 2] != nums[nums.length - 1]) return nums[nums.length - 1];
        return binarySearch(nums, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int start, int end)
    {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            boolean halvesAreEven = (hi - mid) % 2 == 0;
            if (nums[mid + 1] == nums[mid]) {
                if (halvesAreEven) {
                    lo = mid + 2;
                } else {
                    hi = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (halvesAreEven) {
                    hi = mid - 2;
                } else {
                    lo = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[lo];
    }

    // Time complexity : O(logN)
}
