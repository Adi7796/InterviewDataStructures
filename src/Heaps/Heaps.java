package Heaps;

import java.util.ArrayList;

public class Heaps {
    public static void main(String[] args) {
        ArrayList<Integer> heapTree = new ArrayList<>();
        insertNode(heapTree, 3);
        insertNode(heapTree, 5);
        insertNode(heapTree, 9);
        insertNode(heapTree, 4);
        insertNode(heapTree, 1);
        insertNode(heapTree, 10);
        insertNode(heapTree, 11);
        printArr(heapTree);
        deleteNode(heapTree ,10);
        System.out.println();
        printArr(heapTree);

    }

    public static void heapify(ArrayList<Integer> heapTree, int parent)
    {
        int size = heapTree.size();
        int largest = parent;
        int leftChild = (2*parent) + 1;
        int rightChild = (2*parent) + 2;

        if(leftChild < size && heapTree.get(leftChild) > heapTree.get(largest))
            largest = leftChild;
        if(rightChild < size && heapTree.get(rightChild) > heapTree.get(largest))
            largest = rightChild;

        if(largest != parent)
        {
            swap(heapTree, parent, largest);
            heapify(heapTree, largest);
        }
    }

    public static void printArr(ArrayList<Integer> heapTree)
    {
        System.out.println("Heapified arr :");
        for(int i=0; i<heapTree.size(); i++)
        {
            System.out.print(heapTree.get(i) + " ");
        }
    }

    public static void insertNode(ArrayList<Integer> heapTree, int key)
    {
        int size = heapTree.size();
        if(size == 0)
            heapTree.add(key);
        else{
            heapTree.add(key);
            for(int i=(size-1)/2; i>=0; i--)
            {
                heapify(heapTree, i);
            }
        }
    }

    public static void deleteNode(ArrayList<Integer> heapTree, int key)
    {
        int size = heapTree.size();
        int lastElementIndex = size-1;
        int i;
        for(i=0; i<size; i++)
        {
            if(heapTree.get(i) == key)
                break;
        }

        swap(heapTree, lastElementIndex, i);
        heapTree.remove(lastElementIndex);
        for(int j=(size-1)/2; j>=0; j--){
            heapify(heapTree, j);
        }
    }

    public static void swap(ArrayList<Integer> heapTree, int index1, int index2)
    {
        int temp = heapTree.get(index1);
        heapTree.set(index1, heapTree.get(index2));
        heapTree.set(index2, temp);
    }
}

/*
Time Complexity:  O(log(n)) (where n is no of elements in the heap)
Auxiliary Space: O(n)
 */
