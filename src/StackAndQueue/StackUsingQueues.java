package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();
    public static void main(String[] args) {

        // LIFO = Last in first out
        push(1);
        push(2);
        push(5);
        push(10);
        pop();
        pop();
        peek();
        pop();
        pop();
    }

    static void push(int x){
        while (!q1.isEmpty()){
            q2.add(q1.poll());
        }
        q1.add(x);
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
    }

    static void pop(){
        int ans = q1.poll();
        System.out.println(ans);
    }

    static void peek(){
        int ans = q1.peek();
        System.out.println(ans);
    }
}
