package BinarySearch;

/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k.
Each hour, she chooses some pile of bananas and eats k bananas from that pile.
If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
 */

/*
Approach :
If Koko can eat all the piles with a speed of n, she can also finish the task with the speed of n+1.
With a larger eating speed, Koko will spend less or equal time on every pile.
Thus, the overall time is guaranteed to be less than or equal to that of the speed n.
If Koko can't finish with a speed of n, then she can't finish with the speed of n−1 either.
With a smaller eating speed, Koko will spend more or equal time on every pile,
thus the overall time will be greater than or equal to that of the speed n.
 */
public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int h = 6;

        System.out.println(minEatingSpeed(piles, h));
    }

    public static int findMax(int[] piles) {
        int maxi = Integer.MIN_VALUE;;
        int n = piles.length;
        //find the maximum:
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, piles[i]);
        }
        return maxi;
    }

    public static int calculateTotalHours(int[] piles, int hourly) {
        int totalHours = 0;
        int n = piles.length;
        //find total hours:
        // Iterate over the piles and calculate hourSpent.
        // We increase the hourSpent by ceil(piles[i] / middle)
        for (int i = 0; i < n; i++) {
            totalHours += Math.ceil((double)(piles[i]) / (double)(hourly));
        }
        return totalHours;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = findMax(piles);

        //apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            // Check if middle is a workable speed, and cut the search space by half.
            int totalHours = calculateTotalHours(piles, mid);
            if (totalHours <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

/*
Time Complexity: O(N * log(max(a[]))), where max(a[]) is the maximum element in the array and N = size of the array.
Reason: We are applying Binary search for the range [1, max(a[])], and for every value of ‘mid’,
we are traversing the entire array inside the function named calculateTotalHours().

Space Complexity: O(1) as we are not using any extra space to solve this problem.
 */