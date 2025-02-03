package SortingSearching;

/*
Given a sorted array arr[] and a number target, the task is to find the lower bound of the
target in this given array. The lower bound of a number is defined as the smallest index in
the sorted array where the element is greater than or equal to the given number.

Note: If all the elements in the given array are smaller than the target, the lower bound
will be the length of the array.

Examples :

Input:  arr[] = [2, 3, 7, 10, 11, 11, 25], target = 9
Output: 3
Explanation: 3 is the smallest index in arr[] where element (arr[3] = 10) is greater than or equal to 9.
 */
public class LowerBound {

    public static void main(String[] args) {
        int arr[] =  {2, 3, 7, 10, 11, 11, 25};
        int target = 9;

        System.out.println(lowerBound(arr, target));
    }

    static int lowerBound(int[] arr, int target) {
        // code
        int low = 0;
        int high = arr.length-1;

        while(low <= high)
        {
            int mid = (low+high)/2;

            if((target == arr[mid] && mid-1>=0 && arr[mid-1] != target) || (arr[mid] > target && mid -1 >=0 && arr[mid-1] <target))
            {
                return mid;
            }
            else if(arr[mid] < target) low = mid +1;
            else high = mid -1;
        }
        return low;
    }
}
