package LinkedList;

public class AddSingleDigitNumberToLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);
        head.next.next.next = new Node(4);

        printLL(head);
        Node newHead = addDigit(head, 9);
        System.out.println();
        printLL(newHead);
    }

    public static Node addDigit(Node head, int k) {
        // Write your code here...
        Node revHead = reverseList(head);
        System.out.println();
        printLL(revHead);
        int sum = revHead.data + k;
        int carry = sum / 10;
        revHead.data = sum % 10;
        if (carry == 0) {
            return reverseList(revHead);
        }

        Node temp = revHead;
        Node prev = temp;
        temp = temp.next;
        while (carry == 1 && temp != null) {
            sum = temp.data + carry;
            temp.data = sum % 10;
            carry = sum / 10;
            prev = temp;
            temp = temp.next;
        }

        if (carry == 1) {
            prev.next = new Node(carry);
        }
        return reverseList(revHead);
    }

    private static Node reverseList(Node head) {
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            Node nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }
        return prev;
    }

    private static void printLL(Node head) {
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }
}
