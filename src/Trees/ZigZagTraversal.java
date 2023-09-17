package Trees;

import java.util.Stack;

public class ZigZagTraversal {

    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
        }
    }

    public static void zigZagTraversal(Node root)
    {
        Stack<Node> curentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();

        boolean leftToRight = true;
        curentLevel.push(root);

        while(!curentLevel.isEmpty()){
            Node currentNode = curentLevel.pop();
            System.out.print(currentNode.data +" ");
            if(leftToRight){
                if(currentNode.left !=null)
                    nextLevel.push(currentNode.left);
                if(currentNode.right != null)
                    nextLevel.push(currentNode.right);
            }
            else{
                if(currentNode.right != null)
                    nextLevel.push(currentNode.right);
                if(currentNode.left != null)
                    nextLevel.push(currentNode.left);
            }

            if(curentLevel.isEmpty()){
                leftToRight = !leftToRight;
                Stack<Node> temp = new Stack<>();
                curentLevel = nextLevel;
                nextLevel = temp;
            }
        }

    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        zigZagTraversal(root);
    }
}
