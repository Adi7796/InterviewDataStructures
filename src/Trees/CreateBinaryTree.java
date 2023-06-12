package Trees;

import java.util.Scanner;

public class CreateBinaryTree {

    static Scanner sc ;
    static class Node{
        int data;
        Node left, right;

        Node(int data)
        {
            this.data = data;
        }
    }

    public static void main(String[] args)
    {
        sc = new Scanner(System.in);
        //Node root = createTree();
        Node root = new Node(2);
        root.left= new Node(4);
        root.right = new Node(1);
        root.left.left = new Node(7);
        root.left.right = new Node(10);
        root.left.left.left = new Node(6);
        root.right.left = new Node(3);
        root.right.right = new Node(8);
        System.out.println("Inorder traversal : ");
        inOrderTraversal(root);
        System.out.println();
        System.out.println("Preorder traversal : ");
        preOrderTraversal(root);
        System.out.println();
        System.out.println("Postorder traversal : ");
        postOrderTraversal(root);
    }

    static Node createTree()
    {
        Node root = null;
        System.out.println("Enter data  :");
        int data = sc.nextInt();

        root = new Node(data);

        if(data ==-1)
            return null;

        System.out.println("Enter left child for "+ data);
        root.left = createTree();

        System.out.println("Enter right child for "+data);
        root.right = createTree();

        return root;
    }

    static void inOrderTraversal(Node root)
    {
        if(root == null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.data+ " ");
        inOrderTraversal(root.right);
    }

    static void preOrderTraversal(Node root)
    {
        if(root == null)
            return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void postOrderTraversal(Node root)
    {
        if(root == null)
            return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }
}
