package Google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeOverlappingIntervals {

    static class Cell{
        int start;
        int finish;

        Cell(int start, int finish){
            this.start = start;
            this.finish = finish;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "start=" + start +
                    ", finish=" + finish +
                    '}';
        }
    }
    public static void main(String[] args) {
        Cell[] interval = new Cell[5];
        interval[0] = new Cell(8, 10);
        interval[1] = new Cell(1, 5);
        interval[2] = new Cell(3, 4);
        interval[3] = new Cell(6, 7);
        interval[4] = new Cell(10, 12);

        mergeIntervals(interval);
    }

    public static void mergeIntervals(Cell[] intervals)
    {
        Arrays.sort(intervals, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.start - o2.start;
            }
        });

        Stack<Cell> stack = new Stack<>();
        stack.push(intervals[0]);

        for(int i=1;i< intervals.length;i++)
        {
            Cell top = stack.peek();
            if(top.finish < intervals[i].start) {
                stack.push(intervals[i]);
            }
            else if(top.finish < intervals[i].finish){
                top.finish = intervals[i].finish;
                stack.pop();
                stack.push(top);
            }
        }

        while(!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }

    /*
    Time complexity: O(N*log(N))
    Auxiliary Space: O(N)
     */
}
