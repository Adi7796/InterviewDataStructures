package StackAndQueue;

public class QueueUsingArray {

    static int[] arr;
    static int capacity;
    static int rear;

    QueueUsingArray(int n){
        capacity = n;
        arr = new int[n];
        rear = -1;
    }
    public static void main(String[] args) {
        QueueUsingArray obj = new QueueUsingArray(3);
        obj.enqueue(1);
        obj.enqueue(10);
        obj.enqueue(6);
        obj.getFront();
        obj.printArray();
        obj.dequeue();
        obj.printArray();
        obj.getFront();
    }

    // TimeComplexity : O(1)
    public void enqueue(int x){
        if(rear == capacity -1){
            throw new RuntimeException("OverFlow error");
        }
        else{
            rear++;
            arr[rear] = x;
        }
    }

    // TimeComplexity : O(N)
    public int dequeue(){
        if(rear == -1){
            throw new RuntimeException("Empty queue, cant dequeue");
        }
        else{
            int ans = arr[0];
            for(int i=0; i<rear; i++){
                arr[i] = arr[i+1];
            }
            rear--;
            return ans;
        }
    }

    // TimeComplexity : O(1)
    public void getFront(){
        if(rear == -1){
            throw new RuntimeException("Empty queue, cant find first element");
        }
        else{
            System.out.println("First element : " + arr[0]);
        }
    }

    public void printArray(){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
