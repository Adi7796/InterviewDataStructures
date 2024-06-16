package Google;

public class DoubleNumberLinkedList {
    static class Node
    {
        Node next;
        int data;

        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.next = new Node(3);
        root.next.next = new Node(1);

        Node reverseHead = reverseList(root);

        Node temp = reverseHead;
        int current_carry = 0;
        int next_carry = 0;
        Node lastNode = new Node(-1);
        while(temp != null)
        {
            int currentData = temp.data;
            int doubleData = 2*(currentData);
            next_carry = doubleData/10;
            if(current_carry == 0)
                temp.data = doubleData%10;
            else{
                temp.data = (doubleData%10) + current_carry;
            }
            current_carry = next_carry;
            if(temp.next == null) {
                lastNode = temp;
            }
            temp = temp.next;
        }

        if(current_carry != 0)
        {
            lastNode.next = new Node(current_carry);
        }
        Node head = reverseList(reverseHead);
        printList(head);
    }

    public static Node reverseList(Node head)
    {
        Node temp = head;
        Node prev = null;

        while(temp != null)
        {
            Node nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }

        return prev;
    }

    public static void printList(Node head)
    {
        Node temp = head;
        while(temp.next!= null)
        {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }

        System.out.print(temp.data);
    }
}
