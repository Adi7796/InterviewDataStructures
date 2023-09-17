package LinkedList;

// 11->11->11->12->13->13->20->20->21
// result : 11->12->13->20->21

/*
Algorithm: Traverse the list from the head (or start) node.
While traversing, compare each node with its next node.
If the data of the next node is the same as the current node then delete the next node.
Before we delete a node, we need to store the next pointer of the node
 */
public class RemoveDuplicatesInSortedList {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    public static void removeDuplicates(Node head)
    {
     Node tempHead = head;
     while(head != null)
     {
        Node temp = head.next;
        if(temp.data == head.data){
            head.next = temp.next;
            temp.next = null;
        }
        head = head.next;
     }
     while(tempHead != null){
         System.out.println(tempHead.data);
         tempHead = tempHead.next;
     }
    }
    public static void main(String[] args) {
        Node node = new Node(11);
        node.next=new Node(13);
        node.next.next = new Node(12);
        node.next.next.next = new Node(12);
        node.next.next.next.next = new Node(20);
        node.next.next.next.next.next = new Node(22);
        node.next.next.next.next.next.next = new Node(22);

        removeDuplicates(node);
    }
}
