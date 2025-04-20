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
        Node reverseHead = reverseKGroup(head, k);
        printList(reverseHead);
    }

    public static Node reverseKGroup(Node head, int k)
    {
        int cnt = 0;

        Node temp = head;
        // check if k nodes exist in the group
        // if not that means temp becomes null, so we return the head directly
        // e.g : 1->2 is the group for k = 3, we directly return 1->2 without reversing anything
        while(cnt < k)
        {
            if(temp == null)
                return head;

            temp = temp.next;
            cnt++;
        }

        // recursively call for rest of LL
        Node prevNode = reverseKGroup(temp, k);

        // reverse current group
        // normal reversing logic of LL
        temp = head;
        cnt = 0;
        while(cnt < k)
        {
            Node nextNode = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = nextNode;
            cnt++;
        }

        return prevNode;
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
