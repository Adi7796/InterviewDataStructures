package Companies.Google;

import java.util.Stack;

/*
Find the largest rectangular area possible in a given histogram where the largest rectangle
can be made of a number of contiguous bars whose heights are given in an array.
For simplicity, assume that all bars have the same width and the width is 1 unit.
 */
public class LargestRectangularHistogram {
    public static void main(String[] args) {
        //int[] histogram = {6, 2, 5, 4, 5, 1, 6};
        int[] histogram = {2, 4};

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
        for(int i = 0; i < arr.length; i++)
        {
            // while the top of the stack is greater than the current element height
            // we keep popping as we haven't found an element smaller than the current one
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            // if the stack is empty --> we couldn't find any element smaller than the current element
            // hence the current element is the smallest element in the arr
            // hence we assign -1 as the prev smaller element for the current element
            if (stack.isEmpty()) {
                prevSmallerElement[i] = -1;
            // other-wise the top of the stack is the prev smaller element for our current element
            } else {
                prevSmallerElement[i] = stack.peek();
            }
            stack.push(i);
        }
    }

    public static void findNextSmallerElement(int[] arr, int[] nextSmallerElement)
    {
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length-1; i >= 0; i--)
        {

            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                nextSmallerElement[i] = arr.length;
            }
            else{
                nextSmallerElement[i] = stack.peek();
            }
            stack.push(i);
        }
    }

}
