package Trees;

/*
The diameter/width of a tree is defined as the number of nodes on the longest path between two end no des
 */
public class DiameterOfTree {
    static class Height{
        int h;
    }
    public static void main(String[] args) {
        CreateBinarySearchTree.Node root = HeightOfBinaryTree.createBinaryTree();
        System.out.println("Diameter of the tree : "+ findDiameter(root));
        Height height = new Height();
        System.out.println("Diameter of tree using efficient approach : " + findDiameter1(root, height));
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

    public static int findDiameter1(CreateBinarySearchTree.Node root, Height height)
    {
        Height leftHeight = new Height();
        Height rightHeight = new Height();

        if(root == null)
        {
            height.h = 0;
            return 0;
        }

        int leftDiameter = findDiameter1(root.left, leftHeight);
        int rightDiameter = findDiameter1(root.right, rightHeight);

        height.h = Math.max(leftHeight.h , rightHeight.h )+ 1;
        return Math.max(leftHeight.h + rightHeight.h + 1, Math.max(leftDiameter, rightDiameter));
    }
}
