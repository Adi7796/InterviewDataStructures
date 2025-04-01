package Companies.Google;

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class MedianOf2SortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 7, 10, 12};
        int[] nums2 = {2, 3, 6, 15};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        //return findMedianBetterApproach(nums1, nums2, n1, n2);

        if(n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        return findMedianBinaySearch(nums1, nums2);

    }

    private static double findMedianBinaySearch(int[] nums1, int[] nums2)
    {
        int n1 = nums1.length;
        int n2 = nums2.length;

        // low and high signifies the number of elements we pick from nums1
        int low = 0, high = n1;
        // left signifies the number elements to take on the left side
        // of the merged array
        int left = (n1 + n2 + 1)/2;
        int n = n1 + n2;
        while(low <= high)
        {
            // mid1 signifies the number of elements we pick from nums1 till mid1
            // to make the left portion of the array
            int mid1 = (low + high)/2;
            // mid2 signifies the number of elements we pick from nums2 till mid2
            // to make the left portion of the array
            int mid2 = left - mid1;

            // these are indices of the nums1 and nums2 arrays respectively
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            // if the mid and mid-1 elements dont exist we let the indexes to be default
            if(mid1 < n1) r1 = nums1[mid1];
            if(mid2 < n2) r2 = nums2[mid2];
            if(mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if(mid2 - 1 >= 0) l2 = nums2[mid2 - 1];

            // this means we have found our median indexes
            if(l1 <= r2 && l2 <= r1)
            {
                if(n%2 == 0)
                {
                    return (double)(Math.min(r1, r2) + Math.max(l1, l2))/2.0;
                }
                else
                {
                    return Math.max(l1, l2);
                }
            }
            // means we need to pick less elements from nums1
            else if(l1 > r2){
                high = mid1 - 1;
            }
            // we need to pick more elements from nums1
            else{
                low = mid1 + 1;
            }
        }
        return 0.0;
    }

    private static double findMedianBetterApproach(int nums1[], int nums2[], int n1, int n2)
    {
        int[] arr = new int[n1 + n2];

        int i = 0, j = 0;
        int k = 0;
        while(i<n1 && j < n2)
        {
            if(nums1[i] < nums2[j])
            {
                arr[k] = nums1[i];
                i++;
                k++;
            }
            else if(nums1[i] > nums2[j])
            {
                arr[k] = nums2[j];
                j++;
                k++;
            }
            else{
                arr[k] = nums1[i];
                k++;
                arr[k] = nums2[j];
                k++;
                i++;
                j++;
            }
        }

        while(i < n1){
            arr[k] = nums1[i];
            k++;
            i++;
        }

        while(j < n2){
            arr[k] = nums2[j];
            k++;
            j++;
        }

        int len = n1 + n2;
        if((n1+n2)%2 != 0){
            int index = (n1+n2)/2;
            return (double)arr[index];
        }
        else{
            int x = arr[len/2];
            int y = arr[(len/2)-1];

            return (double)(x+y)/2;
        }
    }

}
