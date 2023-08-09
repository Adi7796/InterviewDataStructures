package Trees;
import Trees.CreateBinarySearchTree.Node;
public class CheckIfBstTree {

    //check if the given tree satisfies the BST condition ==> root.data > left.data and root < right.data
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(10);
        root.right = new Node(70);
        root.right.left = new Node(20);
        root.right.right = new Node(80);

        Node root1 = new Node(20);
        root1.left = new Node(10);
        root1.right = new Node(40);
        root1.left.left = new Node(5);
        root1.left.right = new Node(15);
        root1.right.left = new Node(30);
        root1.right.right = new Node(50);

        System.out.println(isBSTUsingInorder(root, Integer.MIN_VALUE));
        System.out.println(isBSTUsingInorder(root1, Integer.MIN_VALUE));
        System.out.println(isBSTUsingRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(isBSTUsingRange(root1, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    /*
    Since Inorder traversal gives a sorted array, we do an inorder traversal
    and keep a track of the previous max value. If the current value is greater than the prev value,
    we will have a sorted array. This is to avoid an extra space complexity of O(N)
    Time Complexity : O(N)
     */
    public static boolean isBSTUsingInorder(Node root, Integer prev)
    {
        if(root == null)
            return true;

        boolean ansLeft = isBSTUsingInorder(root.left, prev);
        if(root.data >= prev) {
            prev = root.data;
        }
        else return false;

        boolean ansRight = isBSTUsingInorder(root.right, prev);

        return ansLeft && ansRight;
    }

    /*
    We can keep a max and min range.
    If the current root falls within that range for all the nodes, we can say the Tree is a BST
    We will update the max range with the Largest number of the left subtree
    and min range as the smallest number in the right subtree
     */
    public static boolean isBSTUsingRange(Node root, Integer minRange, Integer maxRange)
    {
        if(root == null)
            return true;

        if(root.data < minRange || root.data > maxRange)
            return false;
        boolean ansLeft = isBSTUsingRange(root.left, minRange, root.data-1);  // 1 is added same values are not allowed hence we can update the ma value
        boolean ansRight = isBSTUsingRange(root.right, root.data+1, maxRange); // same reason as above

        return ansLeft && ansRight;
    }
}
