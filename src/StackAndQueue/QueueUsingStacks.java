package StackAndQueue;

import java.util.Stack;

public class QueueUsingStacks {

    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();
    public static void main(String[] args) {

        // FIFO - First in First out
        push(1);
        push(2);
        push(3);
        push(4);
        pop();
        pop();
        push(5);
        peek();
        pop();
        pop();
        pop();
    }

    static void push(int x){
        s1.push(x);
    }

    static void pop(){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int ans = s2.pop();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        System.out.println(ans);
    }

    static void peek(){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int ans = s2.peek();
        System.out.println(ans);
    }
}
