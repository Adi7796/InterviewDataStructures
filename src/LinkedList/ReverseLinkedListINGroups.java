package LinkedList;

/*
Time complexity : O(N)
Reason: Nested iteration with O((N/k)*k) which makes it equal to O(N).
Space complexity: 1
 */
public class ReverseLinkedListINGroups {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

    public static Node reverseList(Node head, int k)
    {
        if(head == null || k == 1)
            return head;

        Node dummy = new Node(-1);
        dummy.next = head;
        int count = 1;
        Node temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
            count++;
        }
        System.out.println("Length :" +count);

        Node prev = dummy, curr, nex;

        // since we are making groups of size k, we will only iterate till count >= k
        // as we keep reducing count based on group count
        // we will not reverse the group having size < k
        while(count >= k)
        {
            // initialise current and next nodes
            // prev is a dummy node pointing to the head;
            // eg : for 1st group 1->2->3->4
            // in the first iteration : 2->1->3->4 (curr : 1, prev.next : 2, nex : 3)
            // in the second iteration : 3->2->1->4 (curr : 1, prev.next: 3, nex : 4)
            curr = prev.next;
            nex = curr.next;
            for(int i=1; i<k; i++)
            {
                curr.next = nex.next;
                nex.next = prev.next;
                prev.next = nex;
                nex = curr.next;
            }

            // once the group is reversed, the new current becomes the new prev
            // count gets reduced to reduce the group size
            prev = curr;
            count = count -k;
        }

        // dummy's still points to the head
       return dummy.next;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next=new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(8);
        int groups = 3;

        Node newHead = reverseList(node, groups);
        Node temp = newHead;
        while(temp.next != null)
        {
            System.out.print(temp.data+ "-->");
            temp =  temp.next;
        }
        System.out.print(temp.data);
    }
}
