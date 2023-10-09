package LinkedList;

import java.util.HashSet;

public class IntersectionofUnsortedLinkedList {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }
    public static void main(String[] args) {
        Node headA = null;
        Node headB = null;

        //4->1->8->4->5
        headA = push(headA, 5);
        headA = push(headA, 4);
        headA = push(headA, 8);
        headA = push(headA, 1);
        headA = push(headA, 4);

        //5->6->1->8->4->5
        headB = push(headB, 5);
        headB = push(headB, 4);
        headB = push(headB, 8);
        headB = push(headB, 1);
        headB = push(headB, 6);
        headB = push(headB, 5);

        printList(headA);
        System.out.println();
        printList(headB);
        System.out.println();
        Node nodeOfIntersection = findIntersection(headA, headB);
        if(nodeOfIntersection!= null){
            System.out.println("Intersection found at : "+ nodeOfIntersection.data);
        }
        else{
            System.out.println("No intersection found");
        }

    }

    public static Node push(Node head, int data){
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
        return head;
    }

    public static Node findIntersection(Node headA, Node headB){
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);

        int diffSize = 0;
        int k=1;
        if(sizeA > sizeB){
            diffSize = sizeA - sizeB;
            Node temp = headA;
            while(k<=diffSize){
                temp=temp.next;
                k++;
            }
            return compareLists(temp, headB);
        }
        else{
            diffSize = sizeB - sizeA;
            Node temp = headB;
            while(k<=diffSize){
                temp=temp.next;
                k++;
            }
            return compareLists(headA, temp);
        }
    }

    public static int getSize(Node head){
        if(head == null)
            return 0;

        int size =0;
        while(head!=null){
            size++;
            head = head.next;
        }
        return size;
    }

    public static Node compareLists(Node headA, Node headB){
        while(headA != null){
            if(headA.data == headB.data)  {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public static void printList(Node head){
        while(head.next!=null){
            System.out.print(head.data + "-->");
            head = head.next;
        }
        System.out.print(head.data);
    }
}
