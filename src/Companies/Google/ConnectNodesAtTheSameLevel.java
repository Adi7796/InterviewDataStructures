package Companies.Google;


import java.util.LinkedList;
import java.util.Queue;

/*
Given a Binary Tree, The task is to connect all the adjacent nodes at the same
level starting from the left-most node of that level, and ending at the right-most
node using nextRight pointer by setting these pointers to point the next right for each node.

Input:

        10
       /  \
    12   15
    / \    \
    5   4   3

Output:

     10—>NULL
     / \
   12–>15–>NULL
   / \  \
 5–>4–>  3–>NULL
 */
public class ConnectNodesAtTheSameLevel {

    static class Node{
        int data;
        Node left, right, nextRight;

        Node(int data)
        {
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(5);
        root.left.right = new Node(4);
        root.right.right = new Node(3);

        connectNodes(root);
    }

    public static void connectNodes(Node root)
    {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node start = null;
        while(!queue.isEmpty())
        {
            Node currNode = null;
            int size = queue.size();
            printNodes(start);
            start = queue.peek();

            for(int i=0;i<size;i++)
            {
                Node prevNode = currNode;
                currNode = queue.poll();
                if(i>0)
                    prevNode.nextRight = currNode;
                if(currNode.left !=null){
                    queue.add(currNode.left);
                }
                if(currNode.right != null){
                    queue.add(currNode.right);
                }
            }
            currNode.nextRight = null;
            System.out.println();
        }
        printNodes(start);
    }

    public static void printNodes(Node root)
    {
        while(root!=null)
        {
            System.out.print(root.data +  " -> ");
            root = root.nextRight;
        }
        System.out.print("NULL");
    }
}
