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


Algorithm:
Step 1: Search for the node to delete:

Start from the root and if the key is less than the current node, move to the left subtree and if the
key is greater than the current node, move to the right subtree. Repeat this until we find the node to
delete or reach a null node.


Step 2: Handle Different Cases for Deletion:

Case 1: If the node has no children (leaf nodes), simply remove the node.
Case 2: If the node has one child, replace the node to be deleted with its child.
Case 3: If the node has two children,

Find the node’s inorder predecessor by traversing the left subtree of the node to find the rightmost (largest) node.
Store this as lastRight.

Set the right child lastRight’s to the node to be deleted.

Skip over the node to be deleted by directly connecting the root to the node’s left child ie. the root of the left subtree.
 */
public class DeleteNodeBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.value == key) return helper(root);
        TreeNode dummy = root;
        while(root != null)
        {
            // If the value to be deleted is in the left subtree
            if(key < root.value)
            {
                // If the left child exists and its value matches the key
                if(root.left != null && root.left.value == key)
                {
                    // Delete the node using the helper function
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
        // If the left child of the root is null, return the right child
        if(root.left == null) return root.right;
        // If the right child is null, return the left child
        else if(root.right == null) return root.left;

        // If both left and right children exist
        TreeNode rightChild = root.right; // Store the right child
        TreeNode lastRightChild = findRightMostChild(root.left); // Find the last right child of the left subtree
        lastRightChild.right = rightChild; // Set the right child of the last right node to the stored right child

        return root.left; // Return the left child as the new subtree
    }

    private TreeNode findRightMostChild(TreeNode root)
    {
        while(root.right != null) root = root.right;

        return root;
    }
}

/*
Time Complexity: O(H) where H is the height of the tree. This is due to the binary search applied while
finding the node with value as key. All other operations performed are in constant time.
O(H) ~ O(log N) in case of a full binary search tree (optimal time).
 */