package Trees;

/*
Given the root of a binary tree, your task is to find the diameter of the binary tree.
The diameter of a binary tree is defined as the number of edges on the longest path between any two nodes.
Note that this path may or may not pass through the root of the tree.
 */
public class DiameterOfTree {
    static class Height{
        int h;
    }
    public static void main(String[] args) {
        CreateBinarySearchTree.Node root = HeightOfBinaryTree.createBinaryTree();
        System.out.println("Diameter of the tree : "+ findDiameter(root));
        Height height = new Height();
        System.out.println("Diameter of tree using efficient approach : " + diameter(root));
    }

    //Time Complexity : O(n2)  -> since for every node, we are calling the height -> so for n nodes, n can be the height
    public static int findDiameter(CreateBinarySearchTree.Node root)
    {
        if(root == null)
            return 0;
        int leftDiameter = findDiameter(root.left);
        int rightDiameter = findDiameter(root.right);
        int height = maxHeight(root.right) + maxHeight(root.left) +1;

        return Math.max(Math.max(leftDiameter, rightDiameter), height);
    }

    public static int maxHeight(CreateBinarySearchTree.Node root)
    {
        if(root == null)
            return 0;
        int left = maxHeight(root.left);
        int right = maxHeight(root.right);

        return Math.max(left, right) + 1;
    }

    // efficient Approach O(N)

    public static int diameter(CreateBinarySearchTree.Node root) {
        // code here
        // since java is pas by value and not reference, we create the array so that the value doesn't disappear
        // when the recursion returns to the prev call - small java trick
        int[] maxi = new int[1];
        maxDiameter(root, maxi);
        return maxi[0];
    }


    /*
     * Returns the height of the current subtree while simultaneously
     * updating the maximum diameter found so far.
     *
     * Diameter = Number of edges on the longest path between any two nodes.
     */
    private static int maxDiameter(CreateBinarySearchTree.Node root, int[] maxi) {

        // Base case: height of an empty tree is 0
        if (root == null)
            return 0;

        // Recursively compute heights of left and right subtrees
        int leftHeight = maxDiameter(root.left, maxi);
        int rightHeight = maxDiameter(root.right, maxi);

        // Diameter passing through the current node =
        // height of left subtree + height of right subtree
        maxi[0] = Math.max(maxi[0], leftHeight + rightHeight);

        // Return height of the current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
