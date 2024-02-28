package Google;

import java.util.Stack;

/*
similarly next grater and prev greater can also be found by just reversing the > and < operators
 */
public class NextSmallerAndPrevSmallerElement {
    public static void main(String[] args) {

        NextSmallerAndPrevSmallerElement obj = new NextSmallerAndPrevSmallerElement();
        int[] arr = {4, 10, 5, 8, 20, 15, 3, 12};
        int[] arr1 = {5, 0};

        int[] nextSmallerElement = new int[arr.length];
        int[] prevSmallerElement = new int[arr.length];

        obj.findPrevSmallerElement(arr, prevSmallerElement);
        obj.findNextSmallerElement(arr1, nextSmallerElement);

        for(int i : prevSmallerElement)
            System.out.print(i + " ");

        System.out.println();
        for(int i: nextSmallerElement)
            System.out.print(i+ " ");
    }

    public void findPrevSmallerElement(int[] arr, int[] prevSmallerElement)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        prevSmallerElement[0] = -1;

        for(int i=1;i<arr.length;i++)
        {
            if(!stack.isEmpty())
            {
                if(arr[i] > stack.peek()){
                    prevSmallerElement[i] = stack.peek();
                } else{
                    while(!stack.isEmpty() && stack.peek()>= arr[i]){
                        stack.pop();
                    }
                    if(!stack.isEmpty()) prevSmallerElement[i] = stack.peek();
                    else prevSmallerElement[i] = -1;
                }
                stack.push(arr[i]);
            }

        }
    }

    public void findNextSmallerElement(int[] arr, int[] nextSmallerElement)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[arr.length-1]);
        nextSmallerElement[arr.length-1] = -1;

        for(int i=arr.length-2;i>=0;i--)
        {
            if(!stack.isEmpty())
            {
                if(arr[i] > stack.peek()){
                    nextSmallerElement[i] = stack.peek();
                } else{
                    while(!stack.isEmpty() && stack.peek()>= arr[i]){
                        stack.pop();
                    }
                    if(!stack.isEmpty()) nextSmallerElement[i] = stack.peek();
                    else nextSmallerElement[i] = -1;
                }
                stack.push(arr[i]);
            }

        }
    }
}
