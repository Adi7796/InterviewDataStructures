package Trees;

/*
Given a root node reference of a BST and a key, delete the node with the
given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.

Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

 */
public class DeleteNodeBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.value == key) return helper(root);
        TreeNode dummy = root;
        while(root != null)
        {
            if(key < root.value)
            {
                if(root.left != null && root.left.value == key)
                {
                    root.left = helper(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }
            else
            {
                if(root.right != null && root.right.value == key)
                {
                    root.right = helper(root.right);
                    break;
                }
                else{
                    root = root.right;
                }

            }
        }
        return dummy;
    }

    private TreeNode helper(TreeNode root)
    {
        if(root.left == null) return root.right;
        else if(root.right == null) return root.left;

        TreeNode rightChild = root.right;
        TreeNode rightMostLeftChild = findRightMostChild(root.left);
        rightMostLeftChild.right = rightChild;

        return root.left;
    }

    private TreeNode findRightMostChild(TreeNode root)
    {
        while(root.right != null) root = root.right;

        return root;
    }
}
