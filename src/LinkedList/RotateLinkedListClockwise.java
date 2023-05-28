package LinkedList;

public class RotateLinkedListClockwise {
    public static void main(String[] args)
    {
        LinkedList obj = new LinkedList();
        Node1 head = null;
//        head = obj.insertNode(12,head);
//        head = obj.insertNode(34,head);
//        head = obj.insertNode(77, head);
//        head = obj.insertNode(69, head);
//        head = obj.insertNode(45, head);
//
//        obj.printList(head);
//        System.out.println();
//        //head = obj.reverseLinkedList(head);
//        head = obj.reverseLinkedListRecursively(head);
//        obj.printList(head);

//        head = obj.rotateLinkedList(0,head);
//
          System.out.println();
//        obj.printList(head);

        /// PALINDROME TEST CASE
        head = obj.insertNode(1,head);
        head = obj.insertNode(4,head);
        //head = obj.insertNode(5, head);
        head = obj.insertNode(4, head);
        head = obj.insertNode(1, head);
        obj.printList(head);
        System.out.println();
        System.out.println(obj.palindromicLinkedList(head));
    }
}

class Node
{
    int data;
    Node1 next;

}

class LinkedList
{
    public Node1 rotateLinkedList(int k, Node1 head)
    {
        int size = getSizeOfList(head);
        k = k % size;
        if(k==0)
            return head;
        int i=1;
        Node1 node = head;
        while(i<k)
        {
            i++;
            node = node.next;
        }
        Node1 newHeadNode = node.next;
        node.next=null;
        Node1 temp = newHeadNode;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=head;
        head=newHeadNode;

        return head;
    }

    public Node1 getNewNode(int val) {
        Node1 node = new Node1();
        node.data=val;
        node.next=null;
        return node;
    }

    public int getSizeOfList(Node1 head)
    {
        Node1 node = head;
        if(head==null)
            return 0;

        int count =1;
        while(node!=null){
            count++;
            node=node.next;
        }
        return count;
    }

    public Node1 insertNode(int data, Node1 head)
    {
        if(head==null)
            return getNewNode(data);

        Node1 node = head;
        while(node.next!=null){
            node=node.next;
        }
        node.next=getNewNode(data);
        return head;
    }

    public Node1 reverseLinkedList(Node1 head)
    {
        if(head==null || head.next==null)
            return head;

        if(head.next.next==null)
        {
            Node1 firstnode = head;
            Node1 secondNode = head.next;
            secondNode.next=firstnode;
            firstnode.next=null;
            head = secondNode;

            return head;
        }

        Node1 prevNode = head;
        Node1 temp = head;
        temp=temp.next;
        Node1 nextNode = null;
        while(temp.next!=null)
        {
            nextNode=temp.next;
            temp.next=prevNode;
            prevNode=temp;
            temp=nextNode;
        }
        temp.next=prevNode;
        head.next=null;
        return nextNode;
    }

    public Node1 reverseLinkedListRecursively(Node1 head)
    {
        if(head==null || head.next==null)
            return head;

        Node1 newHead=reverseLinkedListRecursively(head.next);
        Node1 headNext = head.next;
        headNext.next=head;
        head.next=null;

        return newHead;
    }

    public boolean palindromicLinkedList(Node1 head)
    {
        if(head == null)
            return true;

        Node1 mid = getMiddleHead(head);
        Node1 last = reverseLinkedListRecursively(mid);

        Node1 first = head;
        while(first!=last)
        {
            if(first.data != last.data)
                return false;
            first = first.next;
            last=last.next;
        }
        return true;
    }

    public Node1 getMiddleHead(Node1 middleHead)
    {
        Node1 slow = middleHead;
        Node1 fast = middleHead;

        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null)
            return slow.next;
        return slow;
    }

    public void printList(Node1 head)
    {
        if(head==null)
            return;
        else{
            Node1 node = head;
            while(node!=null)
            {
                System.out.print(node.data +"->");
                node=node.next;
            }
        }
    }
}
