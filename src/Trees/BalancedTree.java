package Trees;

/*
Given a binary tree, determine if it is
height-balanced.
 */
public class BalancedTree {

    class TreeNode
    {
        int val;
        TreeNode left, right;
    }
    public boolean isBalanced(TreeNode root)
    {
        if(root == null) return true;

        // int leftHeight = getHeight(root.left);
        // int rightHeight = getHeight(root.right);

        // return (Math.abs(leftHeight - rightHeight) <= 1
        // && isBalanced(root.left)
        // && isBalanced(root.right));

        // the above logic has time complexity of O(n^2) as we are finding the
        // height for every node as we check if its balanced or not

        return optimalHeight(root) == -1 ? false : true;
    }

    public int getHeight(TreeNode root)
    {
        if(root == null) return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }


    /*
    this method optimally checks if the tree is balanced or not in O(N)
    tweaks the height method by returning -1 if at any node we find that the left and
    right subtrees are not balanced and the same is propagated above

    if we get -1 from the subtrees we return false, otherwise if we get a positive height
    we return true as the tree is balanced
     */
    public int optimalHeight(TreeNode root)
    {
        if(root == null)
            return 0;

        int leftHeight = optimalHeight(root.left);
        int rightHeight = optimalHeight(root.right);

        if(leftHeight == -1 || rightHeight == -1) return -1;
        if(Math.abs(leftHeight - rightHeight) > 1) return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
