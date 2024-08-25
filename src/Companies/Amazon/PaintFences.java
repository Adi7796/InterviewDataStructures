package Companies.Amazon;

/*
You are painting a fence of n posts with k different colors. You must paint the posts following these rules:

Every post must be painted exactly one color.
There cannot be three or more consecutive posts with the same color.
Given the two integers n and k, return the number of ways you can paint the fence.

Input: n = 3, k = 2
Output: 6
Explanation: All the possibilities are shown.
Note that painting all the posts red or all the posts green is
invalid because there cannot be three posts in a row with the same color.
Example 2:

Input: n = 1, k = 1
Output: 1
Example 3:

Input: n = 7, k = 2
Output: 42
 */
public class PaintFences {
    public static void main(String[] args) {
        int n = 7;
        int k = 2;

        System.out.println(numWays(n,k));
    }

    public static int numWays(int n, int k) {
        // if the number of fences to be painted is only 1
        // we can choose each color once and paint the fence in k ways as we have k colors
        if(n == 1) return k;

        // if the last 2 colors have to be same
        // we can choose the last -1 color in K ways as we have k colors
        // and then we will have to choose the same color as our last color as well which chose in last-1 fence for which there is only 1 way
        // hence that can be done in K x 1 ways
        int last2SameColors = k*1;

        // if the last 2 colors have to be different
        // we can choose the last -1 color in K ways as we have k colors
        // and then we will have to choose a different color than our last color as we need the last 2 colors to be different
        // this can be done in k-1 ways as we are left with k-1 colors after choosing one color for our last-1 fence
        int last2DifferentColors = k*(k-1);
        int total = last2SameColors + last2DifferentColors;
        for(int i=3;i<=n;i++)
        {
            last2SameColors = last2DifferentColors;
            last2DifferentColors = total * (k-1);
            total = last2SameColors + last2DifferentColors;
        }

        return total;
    }
}
