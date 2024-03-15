package DynamicProgramming;

/*
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is
that adjacent houses have security systems connected and
it will automatically contact the police if two adjacent houses were broken into on the same night.

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber {
    public static void main(String[] args) {

        int[] nums = {2,7,9,3,1};
        int n = nums.length;
        int[] including = new int[n];
        int[] excluding = new int[n];

        including[0] = nums[0];
        excluding[0] = 0;

        for(int i=1;i<n;i++)
        {
            including[i] = excluding[i-1] + nums[i];
            excluding[i] = Math.max(including[i-1], excluding[i-1]);
        }

        System.out.println("Max value : " + Math.max(excluding[n-1], including[n-1]));
    }
}
