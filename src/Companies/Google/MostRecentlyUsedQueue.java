package Companies.Google;

import java.util.HashMap;
import java.util.Map;

public class MostRecentlyUsedQueue
{

    static class Node
    {
        Node next;
        Node prev;
        int data;

        Node(int data)
        {
            this.data = data;
            next = prev = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    Node head;
    Node tail;
    Map<Integer, Node> map;
    public MostRecentlyUsedQueue(int n)
    {
        head = new Node(-1);
        tail = new Node(-2);
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
        initialise(n);
    }

    public void initialise(int n)
    {
        for(int i=1;i<=n;i++)
        {
            if(i==1)
            {
                Node firstNode = new Node(i);
                head.next = firstNode;
                firstNode.prev = head;
                tail.prev = firstNode;
                firstNode.next = tail;
                map.put(i, firstNode);

            }
            else
            {
                Node newNode = new Node(i);
                Node prevNode = map.get(i-1);
                Node nextNode = prevNode.next;
                prevNode.next = newNode;
                newNode.prev = prevNode;
                nextNode.prev = newNode;
                newNode.next = nextNode;
                map.put(i, newNode);
            }
        }
    }

    public int fetch(int k)
    {
        Node temp = head.next;
        for(int i=1;i<k;i++)
        {
            temp = temp.next;
        }
        removeNode(temp.data);
        addNodeToLast(temp.data);
        //System.out.println("Fetched : " + temp.data);
        return k;
    }

    public void removeNode(int k)
    {
        Node nodeToRemove = map.get(k);
        Node prevNode = nodeToRemove.prev;
        Node nextNode = nodeToRemove.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        nodeToRemove.next=nodeToRemove.prev=null;

    }

    public void addNodeToLast(int data) {
        Node newNode = new Node(data);
        Node prevNode = tail.prev;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        tail.prev = newNode;
        newNode.next = tail;
        map.put(data, newNode);
    }

    public static void main(String[] args)
    {
        MostRecentlyUsedQueue mru = new MostRecentlyUsedQueue(3);
        mru.printList();
        mru.fetch(3);
        mru.printList();
        mru.fetch(5);
        mru.printList();
        mru.fetch(2);
        mru.printList();
        mru.fetch(8);
        mru.printList();

    }

    public void printList()
    {
        Node temp = head.next;
        while(temp.next != tail)
        {
            System.out.print(temp.data + " --> ");
            temp=temp.next;
        }
        System.out.print(temp.data);
        System.out.println();
        //System.out.println(map);
    }
}
