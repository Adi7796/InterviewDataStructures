package DynamicProgramming;

/*
Given an integer array height[] where height[i] represents the height of the i-th stair,
a frog starts from the first stair and wants to reach the top. From any stair i,
the frog has two options: it can either jump to the (i+1)th stair or the (i+2)th stair.
The cost of a jump is the absolute difference in height between the two stairs.
Determine the minimum total cost required for the frog to reach the top.

Input: heights[] = [20, 30, 40, 20]
Output: 20
Explanation:  Minimum cost is incurred when the frog jumps from stair 0 to 1 then 1 to 3:
jump from stair 0 to 1: cost = |30 - 20| = 10
jump from stair 1 to 3: cost = |20-30|  = 10
Total Cost = 10 + 10 = 20
 */
public class FrogJump {

    public static void main(String[] args) {
        int[] height = {20, 30, 40, 20};
        System.out.println(minCost(height));
    }
    static int minCost(int[] height)
    {
        int[] dp = new int[height.length];
        for(int i = 0; i<height.length; i++)
        {
            dp[i] = -1;
        }
        // code here
        return recurse(height, height.length-1, dp);

    }

    static int recurse(int[] height, int index, int[] dp)
    {
        if(index == 0) return 0;
        if(index == 1) return Math.abs(height[0] - height[1]);
        if(dp[index] != -1) return dp[index];

        return dp[index] = Math.min(recurse(height, index - 1, dp) + Math.abs(height[index] - height[index-1]),
                recurse(height, index - 2, dp) + Math.abs(height[index] - height[index-2])
        );

    }
}
