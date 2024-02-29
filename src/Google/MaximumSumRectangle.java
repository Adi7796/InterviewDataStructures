package Google;

import DynamicProgramming.LargestSumContiguousSubarray;

import java.util.Arrays;

// Given a 2D array, find the maximum sum submatrix in it.
public class MaximumSumRectangle {
    public static void main(String[] args) {


        int arr[][] = new int[][] { { 1, 2, -1, -4, -20 },

                { -8, -3, 4, 2, 1 },
                { 3, 8, 10, 1, 3 },
                { -4, -1, 1, 7, -6 } };

        int C = arr[0].length;
        int[] sumRow = new int[arr.length];

        int maxSum = Integer.MIN_VALUE;

        for(int cStart=0;cStart<C; cStart++)
        {
            Arrays.fill(sumRow, 0);
            for(int cEnd=cStart; cEnd<C;cEnd++)
            {
                for(int row=0;row < arr.length;row++)
                {
                    sumRow[row] = sumRow[row] + arr[row][cEnd];
                }
                int currMax = LargestSumContiguousSubarray.KadaneAlgorithm(sumRow);
                maxSum = Math.max(currMax, maxSum);
            }
        }

        System.out.println("Maximum Sum : " + maxSum);
    }

/*
Time Complexity: O(c*c*r), where c represents the number of columns and r represents the number of rows in the given matrix.
Auxiliary Space: O(r), where r represents the number of rows in the given matrix.
 */
}
