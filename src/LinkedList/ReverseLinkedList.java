package LinkedList;

public class ReverseLinkedList {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

    public static void reverseList(Node head)
    {
        Node prev = null;
        while(head != null){
            Node temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        head = prev;

        while(head != null)
        {
            System.out.println(head.data);
            head = head.next;
        }
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next=new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        reverseList(node);
    }
}
