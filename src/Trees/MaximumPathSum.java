package Trees;

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
