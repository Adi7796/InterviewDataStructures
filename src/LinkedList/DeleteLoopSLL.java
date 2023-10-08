package LinkedList;

public class DeleteLoopSLL {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        Node temp = node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = temp;

        if(detectAndRemoveLoop(node) == 0){
            System.out.println("No loop present");
        }
        else{
            System.out.println("Linked list after removing loop : ");
            printList(node);
        }

    }

    public static int detectAndRemoveLoop(Node head){
        Node slow = head, fast = head;
        while(slow.next != null && fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast = fast.next.next;

            if(slow == fast)
            {
                System.out.println("Loop detected at node : " +slow.data+ " ,removing loop");
                removeLoop(head, slow);
                return 1;
            }
        }
        return 0;
    }

    public static void printList(Node head)
    {
        while(head.next!=null)
        {
            System.out.print(head.data + " -> ");
            head=head.next;
        }
        System.out.print(head.data);
    }

    public static void removeLoop(Node head, Node slow){
        Node ptr1 = slow;
        Node ptr2 = slow;
        int k=1;

        Node prevNode = ptr1;
        ptr1= ptr1.next;
        while(ptr1!= ptr2)
        {
            prevNode = ptr1;
            ptr1 = ptr1.next;
            k++;
        }
        prevNode.next = null;
    }
}
