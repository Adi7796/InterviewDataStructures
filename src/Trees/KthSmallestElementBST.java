package Trees;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary search tree, and an integer k,
return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
public class KthSmallestElementBST {

    class TreeNode
    {
        int val;
       TreeNode left, right;
    }
    public int kthSmallest(TreeNode root, int k)
    {
        List<Integer> arr = new ArrayList<>();
        if(root == null) return 0;

        inOrderTraversal(root, arr);
        int size = arr.size();
        return arr.get(k-1);
    }

    void inOrderTraversal(TreeNode root, List<Integer> arr)
    {
        if(root == null) return;

        inOrderTraversal(root.left, arr);
        arr.add(root.val);
        inOrderTraversal(root.right, arr);
    }
}
