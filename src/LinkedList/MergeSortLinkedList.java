package LinkedList;

public class MergeSortLinkedList {
    static class Node{
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(12);
        head.next = new Node(2);
        head.next.next = new Node(20);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(40);
        head.next.next.next.next.next = new Node(25);
        head.next.next.next.next.next.next = new Node(35);
        head.next.next.next.next.next.next.next = new Node(50);

        printList(head);
        System.out.println();

        Node newHead = mergeSort(head);
        printList(newHead);
    }

    public static Node mergeSort(Node head)
    {
        if(head == null || head.next == null) return head;

        Node middleNode = findMiddleNode(head);
        Node nextToMiddleNode = middleNode.next;

        middleNode.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(nextToMiddleNode);

        Node sortedListHead = sortedMerge(left, right);
        return sortedListHead;
    }

    public static Node sortedMerge(Node left, Node right)
    {
        if(left == null) return right;
        if(right == null) return left;

        Node result = null;
        if(left.data <= right.data)
        {
            result = left;
            result.next = sortedMerge(left.next, right);
        }
        else{
            result = right;
            result.next = sortedMerge(left, right.next);
        }
        return result;
    }

    public static Node findMiddleNode(Node head)
    {
        if(head == null) return null;

        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
