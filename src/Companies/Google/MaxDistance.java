package Companies.Google;

import java.util.Arrays;

/*
You have been given an array 'A' of N integers. You need to find the maximum value of j - i
subjected to the constraint of A[i] <= A[j], where ‘i’ and ‘j’ are the indices of the array.

For example :
If 'A' = {3, 5, 4, 1}

then the output will be 2.
Maximum value occurs for the pair (3, 4)
 */
public class MaxDistance {
    public static void main(String[] args) {
        int[] arr = {34, 8, 10, 3 ,2 ,80 ,30 ,33 ,1};
        int n = arr.length;

        int[] leftMin = new int[n];
        int[] rightMax = new int[n];

        Arrays.fill(leftMin, Integer.MAX_VALUE);
        Arrays.fill(rightMax, Integer.MIN_VALUE);

        leftMin[0] = arr[0];
        rightMax[n-1] = arr[n-1];

        for(int i=1, j=n-2; i<n && j>=0; i++, j--)
        {
            leftMin[i] = Math.min(leftMin[i-1], arr[i]);
            rightMax[j] = Math.max(rightMax[j+1], arr[j]);
        }

        for(int i : leftMin)
            System.out.print(i + " ");

        System.out.println();
        for(int j : rightMax)
            System.out.print(j + " ");
        System.out.println();

        int i=0, j=0;
        int maxDistance = Integer.MIN_VALUE;
        while(i<n && j< n)
        {
            if(leftMin[i] <= rightMax[j]){
                maxDistance = Math.max(maxDistance, j-i);
                j++;
            }
            else{
                i++;
            }
        }

        System.out.println("Max Distance : " + maxDistance);
        // Maximum value occurs for the pair (8, 33)
    }
}
