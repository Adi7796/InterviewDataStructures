package LinkedList;

public class DeleteNthNodeFromLastSLL {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data= data;
            next = null;
        }
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        int n =2; // int n =5;

        Node head = deleteNthNode(node, n);

        while(head.next != null){
            System.out.print(head.data + "-->");
            head=head.next;
        }
        System.out.print(head.data);
    }

    public static Node deleteNthNode(Node head, int n)
    {
        if(head.next == null){
            return null;
        }

        Node curr = head;
        int size = 0;

        while(curr != null)
        {
            curr = curr.next;
            size++;
        }

        if(size == n)  // if the node to be removed is the head, then return the next of head
            return head.next;

        // This is the position of the element which appears before the element to be deleted
        int prevElement = size - n;
        Node prev = head;
        int k=1;
        while(k<prevElement){
            prev = prev.next;
            k++;
        }
        // after the loop completes, prev will be pointing to the node before the node to be deleted
        // hence point the next of prev to prev.next.next tp delete the next of prev node
        prev.next = prev.next.next;
        return head;
    }
}
