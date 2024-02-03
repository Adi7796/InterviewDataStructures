package Design;

import java.util.HashMap;

public class LRUCache {
    int capacity;
    Node head;
    Node tail;
    HashMap<Integer, Node> cacheMap;
    static class Node{
        Node next;
        Node prev;

        int key, value;
        Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    LRUCache(int capacity)
    {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-2, -2);
        cacheMap = new HashMap<>();

        head.next = tail;
        tail.prev = head;

    }

    public void addNodeToFirst(Node node)
    {
        Node neighbour = head.next;

        head.next = node;
        node.prev = head;
        node.next = neighbour;
        neighbour.prev = node;
    }

    public void removeNode(Node node)
    {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        node.prev = node.next = null;
    }

    public void moveNodeToFirst(Node node)
    {
        removeNode(node);
        addNodeToFirst(node);
    }
    public void get(int key)
    {
        if(cacheMap.get(key) == null)
            System.out.println(-1);
        else{
            Node node = cacheMap.get(key);
            moveNodeToFirst(node);
            System.out.println(node.value);
        }
    }

    public void put(int key, int value)
    {
        Node node = cacheMap.get(key);
        if(node == null){
            Node newNode = new Node(key, value);
            if(cacheMap.size()==capacity)
            {
                Node nodeToBeRemoved = tail.prev;
                removeNode(nodeToBeRemoved);
                cacheMap.remove(nodeToBeRemoved.key);
            }
            cacheMap.put(key, newNode);
            addNodeToFirst(newNode);
        }
        else{
            node.value = value;
            moveNodeToFirst(node);
        }
    }
    public static void main(String[] args)
    {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 10);
        lruCache.put(2, 20);
        lruCache.put(3, 30);
        lruCache.get(1);
        lruCache.put(1, 15);
        lruCache.get(1);
        lruCache.get(2);
        lruCache.put(4, 40);
        lruCache.get(3);
        lruCache.get(4);
    }
}
