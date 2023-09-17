package LinkedList;

public class DetectLoopSLL {

    static class Node{
        int data;
        Node next;
        boolean flag;

        Node(int data){
            this.data = data;
            next = null;
            flag = false;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next=new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        Node temp = node.next.next.next.next;
        temp.next = node;

        if(checkLoop(node))
            System.out.println("No loop exists");
        else
            System.out.println("Loop exists");
    }

    public static boolean checkLoop(Node head){
        while(head != null)
        {
            if(head.flag){
                return false;
            }
            head.flag = true;
            head =  head.next;
        }
        return true;
    }
}
