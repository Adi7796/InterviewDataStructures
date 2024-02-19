package StackAndQueue;

public class CircularQueue {
    int capacity;
    int[] arr;
    int front;
    int rear;

    CircularQueue(int n){
        capacity = n;
        arr = new int[n];
        front = rear = -1;
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(3);

        cq.enqueue(1);
//        cq.enqueue(2);
//        cq.enqueue(3);
        cq.printArray();
        cq.dequeue();
        cq.dequeue();
    }

    public void enqueue(int x){
        if((rear + 1)%capacity == front){
            throw new RuntimeException("queue already full");
        }

        if(front == -1) front = 0;
        rear = (rear + 1)%capacity;
        arr[rear] = x;
    }

    public void dequeue(){
        if(front == -1){
            throw new RuntimeException("Queue empty, cant dequeue");
        }
        int ans = arr[front];
        if(front == rear){
            rear = front = -1;
        }
        else{
            front = (front + 1)%capacity;
        }
        System.out.println("Dequeued element : " + ans);
    }

    public void printArray(){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
