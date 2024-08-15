package Companies.Google;

public class ReverseLinkedListGroupK {
    static class Node{
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }

    static Node reverseList(Node head, int k)
    {
        if(k==0) return head;
        Node temp = head;
        Node prevNode = null, nextNode = null;
        while(temp!=null)
        {
            Node kthNode = findKthNode(temp, k);
            if(kthNode == null)
            { // if the remaining size is less than k
                if(prevNode!=null){
                    prevNode.next = temp;
                    break;
                }
            } else{
                nextNode = kthNode.next;
                kthNode.next = null;
                reverseSmallList(temp);
                if(temp == head){ // if this the first group
                    head = kthNode;
                }else{ // if these are subsequent groups
                    prevNode.next = kthNode;
                }
                prevNode = temp;
                temp = nextNode;
            }
        }


        return head;
    }

    static Node findKthNode(Node temp, int k)
    {
        k = k-1;
        while(temp!=null && k>0){
            k--;
            temp = temp.next;
        }
        return temp;
    }

    static void reverseSmallList(Node head)
    {
        Node prevNode = null;
        Node temp = head;
        while(temp!=null)
        {
            Node nextNode = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = nextNode;
        }
    }

    static void printList(Node head)
    {
        Node temp = head;
        while(temp.next!=null)
        {
            System.out.print(temp.data + " -> ");
            temp=temp.next;
        }
        System.out.print(temp.data);
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        int k = 0;

        printList(head);
        System.out.println();
        Node reverseHead = reverseList(head, k);

        printList(reverseHead);
    }
}
