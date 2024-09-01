package Companies.Amazon;

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
        int h = 5;

        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {

        int left = 1, right = 1;
        for(int pile : piles)
        {
            right = Math.max(right, pile);
        }

        while(left < right)
        {
            // Get the middle index between left and right boundary indexes.
            // hourSpent stands for the total hour Koko spends.
            int middle = (left + right)/2;

            int hourSpent = 0;

            // Iterate over the piles and calculate hourSpent.
            // We increase the hourSpent by ceil(pile / middle)
            for(int pile : piles)
            {
                hourSpent += Math.ceil((double) pile / middle);
            }

            // Check if middle is a workable speed, and cut the search space by half.
            if(hourSpent <= h)
            {
                right = middle;
            }
            else{
                left = middle + 1;
            }
        }

        // Once the left and right boundaries coincide, we find the target value,
        // that is, the minimum workable eating speed.
        return right;
    }
}
