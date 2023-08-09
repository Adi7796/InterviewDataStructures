package Trees;
import Trees.CreateBinarySearchTree.Node;

import java.util.HashSet;
import java.util.Set;

public class TwoSumBST {
    public static void main(String[] args) {
        Node root = HeightOfBinaryTree.createBinaryTree();
        int sum =100;
        Set<Integer> set = new HashSet<>();
        System.out.println(isPresent(root, sum, set));
    }

    public static boolean isPresent(Node root, int sum, Set<Integer> set)
    {
        /*
        Similar to using 2 pointer technique in arrays.
        We are doing a inorder traversal and while doing the traversal we are keeping a track
        that for the number that we are at currently, if there exists a complement in the set
        If
         */
        if(root == null) return false;

        if(isPresent(root.left,sum, set) == true)
            return true;
        if(set.contains(sum - root.data))
            return true;
        else{
            set.add(root.data);
        }
        if(isPresent(root.right, sum, set) == true)
            return true;

        return false;
    }
}
