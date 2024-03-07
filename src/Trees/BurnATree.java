package Trees;
import Trees.CreateBinarySearchTree.Node;

/*
Given a binary tree and target node. By giving the fire to the target node and fire starts to spread in a complete tree. The task is to print the sequence of the burning nodes of a binary tree.
Rules for burning the nodes :

Fire will spread constantly to the connected nodes only.
Every node takes the same time to burn.
A node burns only once.
 */
public class BurnATree {

    static class Depth
    {
        int d;
        Depth(int d){
            this.d = d;
        }
    }
    public static void main(String[] args) {
        Node root = HeightOfBinaryTree.createBinaryTree();
        int target = 10;
        System.out.println("Time taken to burn the entire tree : "+ minTime(root, target));
    }

    static int ans = -1;
    public static int minTime(Node root, int target)
    {
        Depth depth = new Depth(-1);
        burnTree(root, target, depth);
        return ans;
    }

    public static int burnTree(Node root, int target, Depth depth)
    {
        if(root == null) return 0;
        if(root.data == target)
        {
            depth.d = 1;
            return 1;
        }

        Depth leftDepth = new Depth(-1);
        Depth rightDepth = new Depth(-1);

        int leftHeight = burnTree(root.left, target, leftDepth);
        int rightHeight = burnTree(root.right, target, rightDepth);

        if(leftDepth.d != -1) {
            ans = Math.max(ans, rightHeight + leftDepth.d + 1);
            depth.d = leftDepth.d + 1;
        }
        else if(rightDepth.d != -1) {
            ans = Math.max(ans, leftHeight + rightDepth.d + 1);
            depth.d = rightDepth.d + 1;
        }

        return Math.max(leftHeight, rightHeight) +1;
    }
}
