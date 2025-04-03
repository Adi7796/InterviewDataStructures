package LinkedList;

/*
Given the head of a singly linked list, group all the nodes with odd indices together
followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
 */
public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next= new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        ListNode head;
        head = oddEvenList(root);
        while(head.next != null)
        {
            System.out.print(head.val + " --> ");
            head = head.next;
        }
        System.out.println(head.val);
    }
    public static ListNode oddEvenList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        ListNode odd = head;
        ListNode even = head.next;

        while(odd != null)
        {
            temp.next = new ListNode(odd.val);
            temp = temp.next;
            if(odd.next != null) odd = odd.next.next;
            else{
                odd = odd.next;
            }
        }

        while(even != null)
        {
            temp.next = new ListNode(even.val);
            temp = temp.next;
            if(even.next != null) even = even.next.next;
            else{
                even = even.next;
            }
        }

        return dummy.next;
    }
}
