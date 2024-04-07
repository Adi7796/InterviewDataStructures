package DEShaw;

import java.awt.print.PrinterIOException;
import java.util.PriorityQueue;

public class MaxGame {
    public static void main(String[] args) {
        //int[] arr = {2, 3, 1, 4};
        int[] arr = {7, 6, 5, 5, 3};

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<arr.length;i++)
        {
            pq.offer(arr[i]);
        }

        int cost = 0;
        while(pq.size()>1)
        {
            int a = pq.poll();
            int b = pq.poll();

            System.out.println("a = " + a + " | b = " + b);
            cost = cost + a+b;
            pq.offer(a+b);
        }

        System.out.println("Min cost :" + cost);
    }
}
