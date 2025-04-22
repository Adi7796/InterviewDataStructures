package Trees;


import java.util.ArrayList;
import java.util.List;

/*
Left Boundary: Traverse the left boundary of the tree.
Start from the root and keep moving to the left child; if unavailable,
move to the right child. Continue this until we reach a leaf node.

Bottom Boundary: Traverse the bottom boundary of the tree by traversing the leaf nodes using a simple preorder traversal.
We check if the current node is a leaf, and if so, its value is added to the boundary traversal array.

Right Boundary: The right boundary is traversed in the reverse direction, similar to the left boundary traversal
starting from the root node and keep moving to the right child; if unavailable, move to the left child.
Nodes that are not leaves are pushed into the right boundary array from end to start to ensure that they are added
in the reverse direction.
 */
public class BoundaryTraversal {

    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val)
        {
            this.val = val;
        }
    }
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);
        root.right.left = new Node(6);
        root.right.left.left = new Node(9);
        root.right.left.right = new Node(10);

        BoundaryTraversal obj = new BoundaryTraversal();
        obj.boundaryOfBinaryTree(root);
    }

    public void boundaryOfBinaryTree(Node root)
    {
        List<Integer> result = new ArrayList<>();

        if(!isLeafNode(root)) result.add(root.val);

        addLeftBoundary(root, result);
        addLeaves(root, result);
        addRightBoundary(root, result);

        int i;
        for(i =0; i<= result.size()-2; i++)
        {
            System.out.print( result.get(i) + " --> ");
        }
        System.out.println(result.get(i));
    }

    public void addLeftBoundary(Node root, List<Integer> result)
    {
        Node current = root.left;
        while(current != null)
        {
            if(!isLeafNode(current))
            {
                result.add(current.val);
            }

            // Move to the left child if it exists,
            // otherwise move to the right child
            if(current.left != null)
                current = current.left;
            else
                current = current.right;
        }
    }

    public void addLeaves(Node root, List<Integer> result)
    {
        // If the current node is a
        // leaf, add its value to the result
        if(isLeafNode(root))
        {
            result.add(root.val);
            return;
        }

        // Recursively add leaves of
        // the left and right subtrees
        if(root.left != null)
            addLeaves(root.left, result);
        if(root.right != null)
            addLeaves(root.right, result);
    }

    public void addRightBoundary(Node root, List<Integer> result)
    {
        List<Integer> temp = new ArrayList<>();
        Node current = root.right;
        while(current != null)
        {
            if(!isLeafNode(current))
            {
                temp.add(current.val);
            }

            // Move to the right child if it exists,
            // otherwise move to the left child
            if(current.right != null)
                current = current.right;
            else
                current = current.left;
        }

        for(int i = temp.size() -1; i>=0 ; i--)
        {
            result.add(temp.get(i));
        }
    }

    public boolean isLeafNode(Node node)
    {
        return node.left == null && node.right == null;
    }
}

/*
Time Complexity: O(N) where N is the number of nodes in the Binary Tree.

Adding the left boundary of the Binary Tree results in the traversal of the left side of the tree which is proportional
to the the height of the three hence O(H) ie. O(log2N). In the worst case that the tree is skewed the complexity would be O(N).
For the bottom traversal of the Binary Tree, traversing the leaves is proportional to O(N) as preorder traversal visits every node once.
Adding the right boundary of the Binary Tree results in the traversal of the right side of the tree which is proportional
to the the height of the three hence O(H) ie. O(log2N). In the worst case that the tree is skewed the complexity would be O(N).
Since all these operations are performed sequentially, the overall time complexity is dominated by the most expensive operation,
which is O(N).
 */
