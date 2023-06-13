package Trees;
import Trees.CreateBinarySearchTree.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewsBinaryTree {
    public static void main(String[] args) {
        Node root = HeightOfBinaryTree.createBinaryTree();
        leftView(root);
        rightView(root);
    }

    public static void leftView(Node root)
    {
        HashMap<Integer,Node> map = new HashMap<>();
        leftViewUtil(root, map, 0);
        System.out.print("Left View Of Binary Tree: ");
        for(Node i : map.values())
            System.out.print(i.data + " ");
    }

    public static void rightView(Node root)
    {
        HashMap<Integer,Node> map = new HashMap<>();
        rightViewUtil(root, map, 0);
        System.out.println();
        System.out.print("Right View Of Binary Tree: ");
        for(Node i : map.values())
            System.out.print(i.data + " ");
    }

    public static void leftViewUtil(Node root, HashMap<Integer,Node> map, int level)
    {
        if(root == null)
            return;
        if(map.get(level) == null)
            map.put(level, root);
        leftViewUtil(root.left, map, level +1);
        leftViewUtil(root.right, map, level +1);
    }

    public static void rightViewUtil(Node root, HashMap<Integer,Node> map, int level)
    {
        if(root == null)
            return;
        if(map.get(level) == null)
            map.put(level, root);

        rightViewUtil(root.right, map, level +1);
        rightViewUtil(root.left, map, level + 1);
    }
}
