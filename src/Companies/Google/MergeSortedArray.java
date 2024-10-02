package Companies.Google;

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.



Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {4,0,0,0,0,0};
        int m = 1, n= 5;
        int[] nums2 = {1,2,3,5,6};

        merge(nums1, m, nums2, n);
        for(int i : nums1)
        {
            System.out.print(i + " ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n)
    {
        int left = 0, right = m;
        int j = 0;

        while(left != right && j<n)
        {
            if(nums1[left] <= nums2[j] && nums1[right] == 0)
            {
                left++;
            }
            else if(nums1[left] <= nums2[j] && nums1[right] != 0)
            {
                int temp = nums1[right];
                nums1[right] = nums2[j];
                nums1[++right] = temp;
                j++;
            }
            else if(nums1[left] > nums2[j] && nums1[right] == 0)
            {
                int temp = nums1[left];
                nums1[left] = nums2[j];
                nums1[right] = temp;
                left++;
                j++;
            }
            else if(nums1[left] > nums2[j] && nums1[right] != 0)
            {
                if(nums1[right] < nums2[j])
                {
                    int temp = nums1[left];
                    nums1[left] = nums1[right];
                    nums1[right] = temp;
                    left++;
                }
                else
                {
                    int temp = nums1[left];
                    nums1[left] = nums2[j];
                    right++;
                    nums1[right] = temp;
                    j++;
                    left++;
                }
            }
        }

        while(j<n && right < m+n)
        {
            if(nums1[right] > nums2[j])
            {
                int temp = nums1[right];
                nums1[right] = nums2[j];
                nums1[++right] = temp;
                j++;
            }else {
                nums1[++right] = nums2[j];
                j++;
            }
        }
    }
}
