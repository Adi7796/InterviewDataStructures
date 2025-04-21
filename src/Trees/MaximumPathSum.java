package Trees;

/*
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 */
public class MaximumPathSum {

    class TreeNode
    {
        int val;
        TreeNode left, right;
    }
    public int maxPathSum(TreeNode root)
    {
        int maxi[] = {Integer.MIN_VALUE};
        findMaxPathSum(root, maxi);
        return maxi[0];
    }

    // Recursive function to find the maximum path sum
    // for a given subtree rooted at 'root'
    // The variable 'maxi' is a reference parameter
    // updated to store the maximum path sum encountered
    public int findMaxPathSum(TreeNode root, int[] maxi)
    {
        // Base case: If the current node is null, return 0
        if(root == null)
            return 0;

        // Calculate the maximum path sum
        // for the left and right subtrees
        int leftSum = Math.max(0, findMaxPathSum(root.left, maxi));
        int rightSum = Math.max(0, findMaxPathSum(root.right, maxi));

        // Update the overall maximum
        // path sum including the current node
        maxi[0] = Math.max(maxi[0], root.val + leftSum + rightSum);

        // Return the maximum sum considering
        // only one branch (either left or right)
        // along with the current node
        return root.val + Math.max(leftSum, rightSum);
    }
}
