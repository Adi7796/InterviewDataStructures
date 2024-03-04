package LinkedList;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    static class Node{
        int val;
        Node next;

        Node(int val)
        {
            this.val = val;
            next = null;
        }
    }

    static class Pair implements Comparable<Pair>{
        int data;
        Node node;

        Pair(int data, Node node){
            this.data = data;
            this.node = node;
        }

        @Override
        public int compareTo(Pair p1){
            return this.data - p1.data;
        }
    }

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(4);
        list1.next.next = new Node(5);

        Node list2 = new Node(1);
        list2.next = new Node(3);
        list2.next.next = new Node(4);

        Node list3 = new Node(2);
        list3.next = new Node(6);

        Node[] headList = new Node[3];
        headList[0] = list1;
        headList[1] = list2;
        headList[2] = list3;

        Node head = mergeKLists(headList);

        Node temp = head;

        while(temp.next!=null)
        {
            System.out.print(temp.val + " -> ");
            temp=temp.next;
        }
        System.out.print(temp.val);
    }

    public static Node mergeKLists(Node[] lists) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        for(int i=0;i<lists.length;i++)
        {
            pq.add(new Pair(lists[i].val, lists[i]));
        }

        while(!pq.isEmpty())
        {
            Pair currPair = pq.poll();
            Node polledNode = currPair.node;

            temp.next = polledNode;
            temp = temp.next;
            polledNode = polledNode.next;

            if (polledNode!=null) pq.add(new Pair(polledNode.val, polledNode));
        }

        return dummyNode.next;
    }
}
