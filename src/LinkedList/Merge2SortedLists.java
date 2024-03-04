package LinkedList;

public class Merge2SortedLists {
    static class Node{
        int val;
        Node next;

        Node(int val)
        {
            this.val = val;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(4);

        Node list2 = new Node(1);
        list2.next = new Node(2);
        list2.next.next = new Node(3);
        list2.next.next.next = new Node(5);
        list2.next.next.next.next = new Node(6);
        list2.next.next.next.next.next = new Node(7);

        Node head = mergeTwoLists(list1, list2);

        Node temp = head;

        while(temp.next!=null)
        {
            System.out.print(temp.val + " -> ");
            temp=temp.next;
        }
        System.out.print(temp.val);
    }

    public static Node mergeTwoLists(Node list1, Node list2)
    {
        Node head1 = list1;
        Node head2 = list2;
        Node dummyNode = new Node(-1);
        dummyNode.next = null;

        Node temp = dummyNode;

        while(head1 != null && head2 !=null)
        {
            if(head1.val < head2.val)
            {
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            }
            else if(head2.val <= head1.val)
            {
                temp.next = head2;
                temp=temp.next;
                head2 = head2.next;
            }

        }

        if(head1 == null){
            temp.next = head2;
        }else if(head2 == null){
            temp.next = head1;
        }

        return dummyNode.next;
    }

}
