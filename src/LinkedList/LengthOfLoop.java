package LinkedList;

/*
Given the head of a linked list, determine whether the list contains a loop.
If a loop is present, return the number of nodes in the loop, otherwise return 0.

LinkedList: 25->14->19->33->10->21->39->90->58->45, c = 4
Output: 7
 */
public class LengthOfLoop {
    public int countNodesinLoop(ListNode head) {
        // Add your code here.
        ListNode startingNode = findStartingPoint(head);
        if(startingNode == null) return 0;
        int len = 1;

        ListNode temp = startingNode.next;
        while(temp != startingNode)
        {
            len++;
            temp = temp.next;
        }
        return len;
    }

    private static ListNode findStartingPoint(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            {
                slow = head;
                while(slow != fast)
                {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
