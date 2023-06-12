package Trees;

import Trees.CreateBinarySearchTree.Node;
import Trees.HeightOfBinaryTree;
public class SizeOfBinaryTree {
    public static void main(String[] args) {
       Node root =  HeightOfBinaryTree.createBinaryTree();

        System.out.println("Size of Binary tree : "+ size(root));
    }

    public static int size(Node root)
    {
        if(root == null)
            return 0;
        int left = size(root.left);
        int right = size(root.right);

        return left + right + 1;
    }
}
