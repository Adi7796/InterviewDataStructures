package Companies.Amazon;

import java.util.List;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 */
public class Add2NumbersLinkedList {

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
        ListNode root1 = new ListNode(2);
        root1.next = new ListNode(4);
        root1.next.next = new ListNode(3);

        ListNode root2 = new ListNode(5);
        root2.next = new ListNode(6);
        root2.next.next = new ListNode(4);

        ListNode root = addTwoNumbers(root1, root2);
        ListNode temp = root;

        while(temp.next != null)
        {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.print(temp.val);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        int sum, carry = 0;

        while(l1 != null || l2 != null || carry == 1)
        {
            sum = 0;
            if(l1 != null) sum += l1.val;
            if(l2 != null) sum += l2.val;
            if(carry != 0) sum += carry;

            temp.next = new ListNode(sum%10);
            carry = sum/10;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            temp = temp.next;

        }
        return dummy.next;
    }
}
