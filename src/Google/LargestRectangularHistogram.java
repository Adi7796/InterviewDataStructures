package Google;

import java.util.Stack;

/*
Find the largest rectangular area possible in a given histogram where the largest rectangle
can be made of a number of contiguous bars whose heights are given in an array.
For simplicity, assume that all bars have the same width and the width is 1 unit.
 */
public class LargestRectangularHistogram {
    public static void main(String[] args) {
        //int[] histogram = {6, 2, 5, 4, 5, 1, 6};
        int[] histogram = {3, 5, 1, 7, 5, 9};

        int[] nextSmallerElement = new int[histogram.length];
        int[] prevSmallerElement = new int[histogram.length];

        findNextSmallerElement(histogram, nextSmallerElement);
        findPrevSmallerElement(histogram, prevSmallerElement);

        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<histogram.length;i++)
        {
            int width = nextSmallerElement[i] - prevSmallerElement[i] - 1;
            int area = width * histogram[i];
            maxArea = Math.max(area, maxArea);
        }

        System.out.println("Max Area : " + maxArea);
    }

    public static void findPrevSmallerElement(int[] arr, int[] prevSmallerElement)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        prevSmallerElement[0] = -1;

        for(int i=1;i<arr.length;i++)
        {
            if(!stack.isEmpty())
            {
                if(arr[i] > arr[stack.peek()]){
                    prevSmallerElement[i] = stack.peek();
                } else{
                    while(!stack.isEmpty() && arr[stack.peek()]>= arr[i]){
                        stack.pop();
                    }
                    if(!stack.isEmpty()) prevSmallerElement[i] = stack.peek();
                    else prevSmallerElement[i] = -1;
                }
                stack.push(i);
            }

        }
    }

    public static void findNextSmallerElement(int[] arr, int[] nextSmallerElement)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr.length-1);
        nextSmallerElement[arr.length-1] = arr.length;

        for(int i=arr.length-2;i>=0;i--)
        {
            if(!stack.isEmpty())
            {
                if(arr[i] > arr[stack.peek()]){
                    nextSmallerElement[i] = stack.peek();
                } else{
                    while(!stack.isEmpty() && arr[stack.peek()]>= arr[i]){
                        stack.pop();
                    }
                    if(!stack.isEmpty()) nextSmallerElement[i] = stack.peek();
                    else nextSmallerElement[i] = arr.length;
                }
                stack.push(i);
            }

        }
    }

}
