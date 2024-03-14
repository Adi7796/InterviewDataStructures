package LinkedList;

public class IntersectionOfSortedLinkedList {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node a = null;
        Node b = null;
        Node intersect = null;

        /* Let us create the first sorted
          linked list to test the functions
         Created linked list will be
          1.2.3.4.5.6 */
        a = push(a, 6);
        a = push(a, 5);
        a = push(a, 4);
        a = push(a, 3);
        a = push(a, 2);
        a = push(a, 1);

        /* Let us create the second sorted linked list
         Created linked list will be 2.4.6.8 */
        b = push(b, 8);
        b = push(b, 6);
        b = push(b, 4);
        b = push(b, 2);

        intersect = sortedIntersect(a, b);

        System.out.print("\n Linked list containing "
                + "common items of a & b \n ");
        printList(intersect);
    }

    public static Node push(Node head, int data){

        //inserting data at the beginning of the list
        /* Allocate node */
        Node newNode = new Node(data);
        /* Link the old list of the new node */
        newNode.next = head;
        /* Move the head to point to the new node */
        head = newNode;
        return head;
    }

    public static Node sortedIntersect(Node a, Node b)
    {
        Node result = new Node(0);
        // storing the result pointer inside current so as to not lose track of head
        // and use current to traverse the list
        Node current = result;

        while(a!=null && b!=null)
        {
            /* Advance comparing the first
         nodes in both lists.
        When one or the other list runs
         out, we're done. */
            if(a.data == b.data)
            {
                /* found a node for the intersection */
                current.next = new Node(a.data);
                // move current forward only when there is a match
                current = current.next;

                a = a.next;
                b = b.next;
            }
            else if(a.data < b.data)
                a = a.next;    /* advance the smaller list */
            else
                b = b.next;
        }
        // result's next points to the head as we used current to traverse the newly created linked list
        result = result.next;
        return result;
    }

    static void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
