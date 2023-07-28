package Trees;


public class DiameterOfTree {
    public static void main(String[] args) {
        CreateBinarySearchTree.Node root = HeightOfBinaryTree.createBinaryTree();
        System.out.println("Diameter of the tree : "+ findDiameter(root));
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
}
