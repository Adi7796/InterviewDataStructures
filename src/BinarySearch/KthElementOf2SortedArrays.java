package BinarySearch;

/*
Given two sorted arrays a[] and b[] and an element k, the task is to find the element
that would be at the kth position of the combined sorted array.

Examples :

Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
Output: 6
Explanation: The final combined sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element of this array is 6.
Input: a[] = [100, 112, 256, 349, 770], b[] = [72, 86, 113, 119, 265, 445, 892], k = 7
Output: 256
Explanation: Combined sorted array is [72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892].
The 7th element of this array is 256.
 */
public class KthElementOf2SortedArrays {

    public static void main(String[] args) {
        int a[] = {2, 3, 6, 7, 9}, b[] = {1, 4, 8, 10}, k = 5;
        System.out.println(kthElement(a, b, k));
    }
    public static int kthElement(int a[], int b[], int k) {
        // code here
        int n1 = a.length;
        int n2 = b.length;


        if(n1 > n2)
            return kthElement(b, a, k);

        return findKthElement(a, b, k);
    }

    private static int findKthElement(int[] nums1, int[] nums2, int k)
    {
        int n1 = nums1.length;
        int n2 = nums2.length;

        // low and high signifies the number of elements we pick from nums1
        int low = Math.max(0, k - n2), high = Math.min(k, n1);
        // left signifies the number elements to take on the left side
        // of the merged array
        int left = k;
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
                return Math.max(l1, l2);
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
        return 0;
    }
}
