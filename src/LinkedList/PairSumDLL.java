package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class PairSumDLL {

    // Assuming the list is sorted
    // we can use hashing for unsorted list if space is not a constraint
    static class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
        }
    }

    static class Pair{
        int a, b;

        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Node head = null;

        head = insert(head, 9);
        head = insert(head, 8);
        head = insert(head, 7);
        head = insert(head, 6);
        head = insert(head, 5);
        head = insert(head, 4);
        head = insert(head, 3);
        head = insert(head ,2);
        head = insert(head, 1);
        List<Pair> result = checkPairSum(head, 7);
        for(Pair p : result){
            System.out.println(p.a + ","+ p.b);
        }

    }

    public static Node insert(Node head, int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        return head;
    }

    public static List<Pair> checkPairSum(Node head, int sum){
        Node start = head;
        List<Pair> ans = new ArrayList<>();
        while(start.next!= null){
            start = start.next;
        }

        Node last = start;
        start = head;

        while(start != last && start.next != last)
        {
            if(start.data + last.data == sum){
                ans.add(new Pair(start.data, last.data));
                start = start.next;
                last = last.prev;
            }
            else if(start.data + last.data > sum){
                last = last.prev;
            }
            else{
                start = start.next;
            }
        }
        if(start.data + last.data == sum)
            ans.add(new Pair(start.data, last.data));
        return ans;
    }
}
