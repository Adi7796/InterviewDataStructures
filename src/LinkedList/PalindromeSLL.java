package LinkedList;

public class PalindromeSLL {

    static class Node{
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(2);
        node.next.next.next.next.next = new Node(1);

        System.out.println(checkPalindrome(node));
    }

    public static boolean checkPalindrome(Node head)
    {
        if(head == null) return true;
        Node midNode = findMidNode(head);
        Node reverseHead = reverseHalfList(midNode.next);

        while(reverseHead != null)
        {
            if(reverseHead.data != head.data)
                return false;
            reverseHead = reverseHead.next;
            head = head.next;
        }
        return true;

    }

    public static Node findMidNode(Node node)
    {
        Node slow = node;
        Node fast = node;

        while(slow != null && fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node reverseHalfList(Node midNode)
    {
        Node prev = null;
        Node temp = midNode;

        while(temp != null)
        {
            Node nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }
        return prev;
    }
}
