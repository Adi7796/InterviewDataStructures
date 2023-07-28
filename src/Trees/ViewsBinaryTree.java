package Trees;
import Trees.CreateBinarySearchTree.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ViewsBinaryTree {

    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void main(String[] args) {
        Node root = HeightOfBinaryTree.createBinaryTree();
        leftView(root);
        rightView(root);
        topView(root);
        bottomView(root);
    }

    public static void leftView(Node root) {
        HashMap<Integer, Node> map = new HashMap<>();
        leftViewUtil(root, map, 0);
        System.out.print("Left View Of Binary Tree: ");
        for (Node i : map.values())
            System.out.print(i.data + " ");
    }

    public static void rightView(Node root) {
        HashMap<Integer, Node> map = new HashMap<>();
        rightViewUtil(root, map, 0);
        System.out.println();
        System.out.print("Right View Of Binary Tree: ");
        for (Node i : map.values())
            System.out.print(i.data + " ");
    }

    public static void topView(Node root) {
        HashMap<Integer, Node> map = new HashMap<>();
        topViewUtil(root, map);
        System.out.println();
        System.out.print("Top View Of Binary Tree: ");
        for (Node i : map.values())
            System.out.print(i.data + " ");
    }

    public static void bottomView(Node root) {
        HashMap<Integer, Node> map = new HashMap<>();
        bottomViewUtil(root, map);
        System.out.println();
        System.out.print("Bottom View Of Binary Tree: ");
        for (Node i : map.values())
            System.out.print(i.data + " ");
    }

    public static void leftViewUtil(Node root, HashMap<Integer, Node> map, int level) {
        if (root == null)
            return;

        map.putIfAbsent(level, root);

        leftViewUtil(root.left, map, level + 1);
        leftViewUtil(root.right, map, level + 1);
    }

    public static void rightViewUtil(Node root, HashMap<Integer, Node> map, int level) {
        if (root == null)
            return;

        map.putIfAbsent(level, root);

        rightViewUtil(root.right, map, level + 1);
        rightViewUtil(root.left, map, level + 1);
    }

    public static void topViewUtil(Node root, HashMap<Integer, Node> map) {
        // Cannot use recursion here as for cases where we reach a node below the top node
        // we will put it inside the map and not check for elements on the top
        // hence, level order traversal is the right approach here
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair curr = queue.remove();
            if (!map.containsKey(curr.hd))
                map.put(curr.hd, curr.node);

            if (curr.node.left != null)
                queue.add(new Pair(curr.node.left, curr.hd - 1));
            if (curr.node.right != null)
                queue.add(new Pair(curr.node.right, curr.hd + 1));

        }
    }

    public static void bottomViewUtil(Node root, HashMap<Integer, Node> map) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair curr = queue.remove();
            map.put(curr.hd, curr.node);

            if (curr.node.left != null)
                queue.add(new Pair(curr.node.left, curr.hd - 1));
            if (curr.node.right != null)
                queue.add(new Pair(curr.node.right, curr.hd + 1));
        }
    }
}
