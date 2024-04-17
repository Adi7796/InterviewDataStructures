package LinkedList;

public class ReverseListKGroupsRecursion {
    static class Node{
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        int k = 3;
        printList(head);
        System.out.println();
        Node reverseHead = reverseList(head, k);
        printList(reverseHead);
    }

    public static Node reverseList(Node head, int k)
    {
        if(head == null) return null;
        Node temp = head;
        Node prev = null;

        int x = k;
        while(k-- > 0 && temp != null)
        {
            Node nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }

        head.next = reverseList(temp, x);
        return prev;
    }

    public static void printList(Node head)
    {
        Node temp = head;
        while(temp.next != null)
        {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }
}
