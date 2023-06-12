package Trees;
import Trees.CreateBinarySearchTree.Node;
public class HeightOfBinaryTree {
    public static void main(String args[])
    {
        Node root = createBinaryTree();

        System.out.println("Height of Binary tree : "+ height(root));

        System.out.println("Maximum node in Binary tree : "+maximumInBinaryTree(root));
    }

    public static Node createBinaryTree()
    {
        Node root = new Node(2);
        root.left= new Node(4);
        root.right = new Node(1);
        root.left.left = new Node(45);
        root.left.right = new Node(10);
        root.left.left.left = new Node(6);
        root.right.left = new Node(3);
        root.right.right = new Node(8);

        return root;
    }

    public static int height(Node root)
    {
        if(root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int maximumInBinaryTree(Node root)
    {
        if(root == null)
            return -1;

        int maxLeft = maximumInBinaryTree(root.left);
        int maxRight = maximumInBinaryTree(root.right);

        return Math.max(Math.max(maxLeft, maxRight), root.data);
    }
}
