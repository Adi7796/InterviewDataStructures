package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PeakElement {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 8, 1, 5, 3));
        // Write your code here.
        int peakElement;
        if(arr.get(0)> arr.get(1)) peakElement = arr.get(0);
        else if(arr.get(arr.size()-1) > arr.get(arr.size()-2)) peakElement = arr.get(arr.size()-1);
        else
            peakElement = peakElement(1, arr.size()-2, arr);
        System.out.println("Peak element : " + peakElement);
    }
    public static int peakElement(int low, int high, ArrayList<Integer> arr)
    {
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(arr.get(mid) > arr.get(mid-1) && arr.get(mid)>arr.get(mid+1))
                return arr.get(mid);

            else if(mid < arr.size()-1 && arr.get(mid+1) > arr.get(mid-1))
                low = mid+1;
            else if(mid > 0 && arr.get(mid-1) > arr.get(mid+1))
                high = mid-1;
        }
        return -1;
    }
}
