package Arrays;

/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class RotateArray {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);

        for(int i : nums)
        {
            System.out.print(i + " ");
        }

    }
    public static void rotate(int[] nums, int k) {
        int [] arr = new int[nums.length];
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            arr[(i+k)%n]=nums[i];
        }
        for(int j=0;j<arr.length;j++)
            nums[j]=arr[j];
    }
}
