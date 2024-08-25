package Companies.Amazon;

/*
There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by an n x k cost matrix costs.

For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on...
Return the minimum cost to paint all houses.

Example 1:

Input: costs = [[1,5,3],[2,9,4]]
Output: 5
Explanation:
Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
Example 2:

Input: costs = [[1,3],[2,4]]
Output: 5
 */
public class PaintHouse2 {
    public static void main(String[] args) {

        int[][] costs = {{1,3},{2,4}};
        System.out.println(minCostII(costs));
    }

    public static int minCostII(int[][] costs) {

        int m = costs.length;
        int n = costs[0].length;

        int[][] dp = new int[m][n];

        int least = Integer.MAX_VALUE;
        int secondLeast = Integer.MAX_VALUE;

        for(int j=0;j<n;j++)
        {
            //initialise the first row of dp array by painting the houses with the cost array
            // also keep track of the least and second least
            int cost = costs[0][j];
            dp[0][j] = cost;
            if(cost <= least)
            {
                secondLeast = least;
                least = cost;
            }
            else if(cost <= secondLeast)
            {
                secondLeast = costs[0][j];
            }
        }

        for(int i=1; i<m;i++)
        {
            int newLeast = Integer.MAX_VALUE;
            int newSecondLeast = Integer.MAX_VALUE;
            for(int j=0;j<n; j++)
            {
                // if least is equal to the cost of painting the prev house with the same color
                // then we need to add the second least cost
                if(dp[i-1][j] == least)
                {
                    dp[i][j] = costs[i][j] + secondLeast;
                }
                // else we add the least cost
                else
                {
                    dp[i][j] = costs[i][j] + least;
                }


                // nned to keep track of the new least and new second least for the houses i>=1
                if(dp[i][j] <= newLeast)
                {
                    newSecondLeast = newLeast;
                    newLeast = dp[i][j];
                }
                else if(dp[i][j] <= newSecondLeast)
                {
                    newSecondLeast = dp[i][j];
                }
            }

            least = newLeast;
            secondLeast = newSecondLeast;
        }

        return least;
    }
}
