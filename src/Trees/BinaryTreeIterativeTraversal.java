package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeIterativeTraversal {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);

        List<Integer> ans = postorderTraversal(root);
        ans.stream().forEach(System.out::print);
        System.out.println();
        ans = preorderTraversal(root);
        ans.stream().forEach(System.out::print);
        System.out.println();
        ans = inorderTraversal(root);
        ans.stream().forEach(System.out::print);
    }


    // left subtree, right subtree, root
    public static List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> ansList = new ArrayList<>();
        if(root == null) return ansList;

        stack1.push(root);

        while(!stack1.isEmpty())
        {
            TreeNode topNode = stack1.pop();
            stack2.push(topNode);

            if(topNode.left != null) stack1.push(topNode.left);
            if(topNode.right != null) stack1.push(topNode.right);
        }

        while(!stack2.isEmpty())
        {
            ansList.add(stack2.pop().value);
        }

        return ansList;
    }

    //Root-Left-Right
    public static List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ansList = new ArrayList<>();
        if(root == null) return ansList;
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode topNode = stack.pop();
            ansList.add(topNode.value);
            if(topNode.right!= null) stack.push(topNode.right);
            if(topNode.left != null) stack.push(topNode.left);
        }

        return ansList;
    }

    // left subtree, root, right subtree
    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ansList = new ArrayList<>();

        if(root == null) return ansList;

        TreeNode node = root;
        while(true)
        {
            if(node != null)
            {
                stack.push(node);
                node = node.left;
            }
            else{
                if(stack.isEmpty()) break;
                node = stack.pop();
                ansList.add(node.value);
                node = node.right;
            }
        }

        return ansList;
    }
}
