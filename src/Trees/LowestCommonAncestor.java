package Trees;
import Trees.CreateBinarySearchTree.Node;
public class LowestCommonAncestor {
    public static void main(String[] args) {
        CreateBinarySearchTree.Node root = HeightOfBinaryTree.createBinaryTree();
        System.out.println("Lowest common ancestor of the the nodes 6 & 10 is : "+ findLowestCommonAncestor(root,6,10 ).data);
        System.out.println("Lowest common ancestor of the the nodes 6 & 8 is : "+ findLowestCommonAncestor(root,6,8 ).data);

    }

    public static Node findLowestCommonAncestor(Node root, int a, int b)
    {
        /* Using 4 conditions :-
        1) If data == a || data == b, then return this value itself, one of the value is the common ancestor
        2) If a is found in left subtree and b is found in right subtree, then return the current root
        3) Both a & b in any one subtree
        4) None of a & b are in any subtree then we return null
         */
        if(root == null) return null;
        if(root.data == a || root.data == b) return root;

        Node left = findLowestCommonAncestor(root.left, a, b);
        Node right = findLowestCommonAncestor(root.right, a, b);

        if(left == null) return right;
        if(right == null) return left;

        return root;
    }
}
