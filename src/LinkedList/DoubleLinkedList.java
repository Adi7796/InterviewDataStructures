package LinkedList;

public class DoubleLinkedList {

    static Node head;
    static Node last;
    static class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            next = null;
            prev = null;
        }
    }
    public static void main(String[] args) {
        insertFirst(4);
        insertFirst(3);
        insertFirst(2);
        insertFirst(1);
        insertLast(5);
        insertAfter(4, 10);
        insertBefore(5, 20);
        printList();
    }

    public static void insertFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            last = newNode;
        }
        else{
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
        }
    }

    public static void insertLast(int data){
        Node newNode = new Node(data);
        if(last == null){
            last = newNode;
            head = newNode;
        }
        else{
            newNode.next = null;
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
    }

    public static void insertAfter(int data, int newData){
        Node newNode = new Node(newData);
        if(last == head && head.data == data){
            insertLast(newData);
            return;
        }
        else if(head == null){   // new element data present to insertAfter
            return;
        }

        Node curr = head;
        while(curr.data != data){
            curr = curr.next;
        }
        Node nextNode = curr.next;

        newNode.prev = curr;
        newNode.next = nextNode;

        curr.next = newNode;
        nextNode.prev = newNode;
    }

    public static void insertBefore(int data, int newData){
        Node newNode = new Node(newData);
        if(head == last && head.data == data){
            insertFirst(newData);
        }
        Node curr = head;
        while(curr.data != data){
            curr = curr.next;
        }

        Node prevNode = curr.prev;

        prevNode.next = newNode;
        curr.prev = newNode;

        newNode.next = curr;
        newNode.prev = prevNode;
    }

    public static void printList(){
        System.out.println("Printing list from start : ");
        while(head.next!= null){
            System.out.print(head.data + "-->");
            head = head.next;
        }
        System.out.print(head.data);
        System.out.println();
        System.out.println("Printing list in reverse order : ");
        while(last.prev!= null){
            System.out.print(last.data + "-->");
            last = last.prev;
        }
        System.out.print(last.data);
    }
}
