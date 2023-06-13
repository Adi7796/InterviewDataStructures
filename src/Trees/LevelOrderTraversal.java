package Trees;
import Trees.HeightOfBinaryTree;
import Trees.CreateBinarySearchTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node root = HeightOfBinaryTree.createBinaryTree();

        System.out.println("Level order traversal :- ");
        levelTraversal(root);
    }

    public static void levelTraversal(Node root)
    {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            Node current = queue.remove();
            System.out.print(current.data+ " ");
            if(current.left!=null)
                queue.add(current.left);
            if(current.right!=null)
                queue.add(current.right);
        }
    }
}
