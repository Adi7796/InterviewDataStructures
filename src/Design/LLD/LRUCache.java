package Design.LLD;

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
        if(cacheMap.get(key) == null)   // if the node is not found inside the cache, that means we dont have the key in cache
            System.out.println(-1);  // return -1 by default
        else{
            Node node = cacheMap.get(key);  // we get the node for the key asked
            moveNodeToFirst(node); // move the node to first to make it most recently used
            System.out.println(node.value);  // print the value
        }
    }

    public void put(int key, int value)
    {
        Node node = cacheMap.get(key);
        if(node == null){ // this means the node doesn't exist in the cache hence we need to directly insert it
            Node newNode = new Node(key, value);
            if(cacheMap.size()==capacity)  // if the capacity is reached, we remove the least recently used node which is at the last of the linked list
            {
                Node nodeToBeRemoved = tail.prev;  // the node to be removed is the last node, hence can be found by tail prev
                removeNode(nodeToBeRemoved);  // remove last node
                cacheMap.remove(nodeToBeRemoved.key); // remove this node from the map as well
            }
            cacheMap.put(key, newNode);  // put the new node into the map/cache
            addNodeToFirst(newNode);  // move this node to the beginning of the DLL to make it most recently used
        }
        else{  // node exists in the cache, hence we need to update its value
            node.value = value;
            moveNodeToFirst(node);  // Moving the node to start to make it most recently used
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
