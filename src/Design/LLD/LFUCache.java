package Design.LLD;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    Map<Integer, Node> cacheMap; // for storing (Key -> Node pairs) as we need to keep track of what keys we have in our cache
    Map<Integer, DoubleLinkedList> freqMap; // for storing ( freq --> DoubleLinkedList) as we need a list of all the Nodes with a particular freq
    int minFrequency; // to keep track of the minFreq, this helps us in deciding which Node to remove as the Node with
    // minfreq and at the last of double list will be removed
    int cacheCapacity;

    public LFUCache(int cacheCapacity)
    {
        this.cacheCapacity = cacheCapacity;
        minFrequency = 0;
        cacheMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key)
    {
        if(cacheCapacity == 0) return -1;
        Node node = cacheMap.get(key);
        if(node == null) return -1; // if the key doesn't exist

        increaseFrequency(node); // else increase the freq of the node and return the value
        return node.value;
    }

    public void put(int key, int value)
    {
        // if the key already exists in the cacheMap
        // we only update the value and update the frequency
        if(cacheMap.containsKey(key))
        {
            Node node = cacheMap.get(key);
            node.value = value;
            increaseFrequency(node);
            cacheMap.put(key, node);
            return;
        }

        // if the key doesn't exist and cache map is at max capacity
        if(cacheMap.size() == cacheCapacity)
        {
            DoubleLinkedList minFreqList = freqMap.get(minFrequency); // get the min freq list
            Node toRemove = minFreqList.removeLastNode(); // get the last node as that's the least recently used node
            cacheMap.remove(toRemove.key); // remove this node from the cache map
        }

        Node newNode = new Node(key, value); // create a new node since this node didn't exist
        addNodeToFreqMap(newNode);
        cacheMap.put(key, newNode);
        minFrequency = 1;   // reset the min freq as this was a new node with freq = 1
    }

    public void increaseFrequency(Node node)
    {
        int currentFreq = node.frequency; // get the current freq of the current node
        DoubleLinkedList currentList = freqMap.get(currentFreq); // get the list for this frequency
        currentList.removeNode(node); // remove this node from the current list as we are going to increase the freq fo this node
        if(currentList.isEmpty()) // after removing this node if the list becomes empty we need to remove this freq from the freqMap
        {
            freqMap.remove(currentFreq);
            if(minFrequency == currentFreq) { // if the currentFreq was itself the minfreq, we increment the minFreq
                minFrequency++;
            }
        }
        node.frequency++;  // finally increment the current node freq
        addNodeToFreqMap(node); // add this to the first of the DoubleLinkedList as this was recently used
    }

    public void addNodeToFreqMap(Node node)
    {
        int newFreq = node.frequency; // get th new incremented freq
        DoubleLinkedList newList = freqMap.getOrDefault(newFreq, new DoubleLinkedList());
        newList.addToFirst(node); // add the node to the first of the list denoting it's the most recently used
        freqMap.put(newFreq, newList); // put the list with the new freq back to the freq map
    }
    static class Node
    {
        int key;
        int value;
        int frequency;
        Node next;
        Node prev;

        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    static class DoubleLinkedList
    {
        Node head;
        Node tail;
        public DoubleLinkedList()
        {
            head = new Node(-1, -1);
            tail = new Node(-2, -2);
            head.next = tail;
            tail.prev = head;
        }

        public void addToFirst(Node node)
        {
            Node nextNode = head.next;

            head.next = node;
            node.prev = head;

            node.next = nextNode;
            nextNode.prev = node;
        }

        public Node removeNode(Node node)
        {
            Node nextNode = node.next;
            Node prevNode = node.prev;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;

            node.next = node.prev = null;

            return node;
        }

        public Node removeLastNode()
        {
            if(isEmpty()) return null;
            else{
                return removeNode(tail.prev);
            }
        }

        public boolean isEmpty()
        {
            return head.next == tail;
        }
    }

    public static void main(String[] args)
    {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }
}
