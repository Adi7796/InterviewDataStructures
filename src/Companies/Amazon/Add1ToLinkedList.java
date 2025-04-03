package Companies.Amazon;

/*
You are given a linked list where each element in the list is a node and have an integer data.
You need to add 1 to the number formed by concatinating all the list node numbers together and
 return the head of the modified linked list.

Note: The head represents the first element of the given array.

Examples :

Input: LinkedList: 4->5->6
Output: 457
 */
public class Add1ToLinkedList {

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val)
        {
            this.val = val;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode root1 = new ListNode(4);
        root1.next = new ListNode(5);
        root1.next.next = new ListNode(6);

        ListNode root = addOne(root1);
        ListNode temp = root;

        while(temp.next != null)
        {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.print(temp.val);
    }

    public static ListNode addOne(ListNode head) {
        // code here.
        if(head == null) return null;

        int carry = recurse(head);
        if(carry == 1)
        {
            ListNode newNode = new ListNode(1);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    private static int recurse(ListNode temp)
    {
        if(temp == null) return 1;

        int carry = recurse(temp.next);

        temp.val = temp.val + carry;

        if(temp.val < 10)
            return 0;

        temp.val = 0;
        return 1;

    }
}
