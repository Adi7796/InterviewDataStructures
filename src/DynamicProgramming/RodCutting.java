package DynamicProgramming;

/*
Given a rod of length ‘N’ units.
The rod can be cut into different sizes and each size has a cost associated with it.
Determine the maximum cost obtained by cutting the rod and selling its pieces.

Note:
1. The sizes will range from 1 to ‘N’ and will be integers.

2. The sum of the pieces cut should be equal to ‘N’.

3. Consider 1-based indexing.

Eg -
5
2 5 7 8 10

All possible partitions are:
1,1,1,1,1           max_cost=(2+2+2+2+2)=10
1,1,1,2             max_cost=(2+2+2+5)=11
1,1,3               max_cost=(2+2+7)=11
1,4                 max_cost=(2+8)=10
5                   max_cost=(10)=10
2,3                 max_cost=(5+7)=12
1,2,2               max _cost=(1+5+5)=12

Clearly, if we cut the rod into lengths 1,2,2, or 2,3, we get the maximum cost which is 12.
 */
public class RodCutting {
    public static void main(String[] args) {
        int n = 5;
        int[] price = {2, 5, 7, 8, 10};

        int[] dp = new int[n+1];
        dp[0] = 0;

        // we run an outer loop to check the max price of cutting a rod till ith length.
        for(int i=1;i<=n;i++)
        {
            int maxPrice = Integer.MIN_VALUE;
            // we run an internal loop to check loop over all the possible lengths that can be used
            // to achieve an ith length
            // i-j-1 gives the length of the remaining rod if we choose to cut the rod at jth length
            // hence we add the price[j] to the ans as we have cut the ith length as j and i-j-1
            for(int j=0; j<i;j++)
            {
                maxPrice = Math.max(maxPrice, dp[i-j-1] + price[j]);
            }
            dp[i] = maxPrice;
        }

        System.out.println("Max price : " + dp[n]);
    }
}
