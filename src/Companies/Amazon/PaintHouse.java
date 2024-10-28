package Companies.Amazon;

/*
There is a row of n houses, where each house can be painted one of three colors: red, blue, or green.
The cost of painting each house with a certain color is different.
You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.

For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2]
is the cost of painting house 1 with color green, and so on...
Return the minimum cost to paint all houses.

Example 1:

Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
Minimum cost: 2 + 5 + 3 = 10.
Example 2:

Input: costs = [[7,6,2]]
Output: 2
 */
public class PaintHouse {
    public static void main(String[] args) {
        int[][] costs = {{17,2,17},
                         {16,16,5},
                         {14,3,19}};

        System.out.println(minCost(costs));

    }

    public static int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];

        // Initialise the dp array by painting the first house with one color at a time
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for(int i = 1; i<n; i++)
        {
            // the min cost of painting the current house with red is
            // cost of painting it with red + min of the costs of painting the prev house with either green or blue
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            // cost of painting it with blue + min of the costs of painting the prev house with either red or green
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            // cost of painting it with green + min of the costs of painting the prev house with either red or blue
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);

        }

        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }
}
