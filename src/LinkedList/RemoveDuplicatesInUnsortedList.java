package LinkedList;

import java.util.HashSet;

/*
Use a hashset to store the values of the list
check if the value already exists in the set
if the value exists, use a prev ptr to point to the current's next by skipping the next node
 */
public class RemoveDuplicatesInUnsortedList {

    static class Node{
        int data;

        Node next;

        Node(int data)
        {
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Node node = new Node(12);
        node.next=new Node(13);
        node.next.next = new Node(10);
        node.next.next.next = new Node(12);
        node.next.next.next.next = new Node(10);
        node.next.next.next.next.next = new Node(12);
        node.next.next.next.next.next.next = new Node(11);

        Node head = removeDuplicates(node);
        while(head!=null)
        {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static Node removeDuplicates(Node head)
    {
        HashSet<Integer> set = new HashSet<>();
        Node current = head;
        Node prev = null;

        while(current != null)
        {
            if(set.contains(current.data))
            {
                prev.next = current.next;

            }
            else{
                set.add(current.data);
                prev = current;
            }
            current = current.next;
        }
        return head;
    }
}
